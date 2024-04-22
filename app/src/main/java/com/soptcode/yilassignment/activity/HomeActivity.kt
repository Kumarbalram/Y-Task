package com.soptcode.yilassignment.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.soptcode.yilassignment.R
import com.soptcode.yilassignment.adapter.ContactListAdapter
import com.soptcode.yilassignment.databinding.ActivityHomeBinding
import com.soptcode.yilassignment.databinding.ItemDetailsBinding
import com.soptcode.yilassignment.model.NameResponse
import com.soptcode.yilassignment.utils.ErrorUtil
import com.soptcode.yilassignment.utils.NetworkUtils
import com.soptcode.yilassignment.utils.ProgressDialogUtil
import com.soptcode.yilassignment.utils.showToast
import com.soptcode.yilassignment.viewmodel.NameListViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var nameListViewModel: NameListViewModel
    lateinit var adapter: ContactListAdapter
    lateinit var binding: ActivityHomeBinding
    private lateinit var updateLocAndLangDialogs: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        nameListViewModel = ViewModelProvider(this).get(NameListViewModel::class.java)
        setContentView(binding.root)
        nameListObserver()
        hitNameList()
        inItViews()
    }


    fun inItViews() {
        binding.share.setOnClickListener {
            var i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(
                Intent.EXTRA_TEXT,
                "http://pandora.yilstaging.com/writable/uploads/20210127/1611811599_2ac19cd41e8387119d7e.mp3"
            )
            this.startActivity(i)
        }
    }

    private fun nameListObserver() {
        nameListViewModel.nameListResponse.observe(this, androidx.lifecycle.Observer {
            adapter = ContactListAdapter(
                this,
                it as ArrayList<NameResponse.NameResponseItem>,
                object : ContactListAdapter.ClickName {
                    override fun clickOnNameList(position: Int) {
                        showItemDetailsDialog(
                            it[position].realname,
                            it[position].team,
                            it[position].firstappearance,
                            it[position].createdby,
                            it[position].publisher,
                            it[position].name,
                            it[position].imageurl,
                            it[position].bio
                        )

                    }

                })
            binding.listRecycler.adapter = adapter
            showToast("List fetch successfully")

        })
        nameListViewModel.errorProfile.observe(this, androidx.lifecycle.Observer {
            ProgressDialogUtil.getInstance().hideProgress()
            ErrorUtil.handlerGeneralError(this, binding.listRecycler, it)
        })
        nameListViewModel.progressProfile.observe(this, androidx.lifecycle.Observer {
            if (it) {
                ProgressDialogUtil.getInstance().showProgress(this, true)
            } else {
                ProgressDialogUtil.getInstance().hideProgress()
            }
        })
    }

    fun hitNameList() {
        if (NetworkUtils.isInternetAvailable(this)) {

            nameListViewModel.hitNameList(
            )

        } else {
            showToast("Please check your internet")
        }
    }

    private fun showItemDetailsDialog(
        realname: String,
        team: String,
        firstappearance: String,
        createdby: String,
        publisher: String,
        name: String,
        imageurl: String,
        bio: String
    ) {
        val binding: ItemDetailsBinding = ItemDetailsBinding.inflate(layoutInflater)
        updateLocAndLangDialogs = Dialog(this)
        updateLocAndLangDialogs.requestWindowFeature(Window.FEATURE_NO_TITLE)
        updateLocAndLangDialogs.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        updateLocAndLangDialogs.setCancelable(false)
        updateLocAndLangDialogs.setContentView(binding.root)
        updateLocAndLangDialogs.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        updateLocAndLangDialogs.setCanceledOnTouchOutside(true)
        binding.tvRealName.text = "Real name : $realname"
        binding.tvTeam.text = "Team : $team"
        binding.tvFirstAppearance.text = "First appearance : $firstappearance"
        binding.tvCreatedBy.text = "Created by : $createdby"
        binding.tvPublisher.text = "Publisher : $publisher"
        binding.tvName.text = "Name : $name"
        binding.tvBio.text = "Bio : ${bio.trimStart()}"
        Glide.with(this).load(imageurl).placeholder(R.drawable.user).into(binding.userImage)
        updateLocAndLangDialogs.show()
    }

}