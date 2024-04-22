package com.soptcode.yilassignment.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.TextUtils
import android.text.format.DateFormat
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.soptcode.yilassignment.R
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.*
import java.lang.Exception
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

// To Get String With Trim From View
fun EditText.getString(): String {
    return this.text.toString().trim()
}

// To Get String With Trim From View
fun TextView.getString(): String {
    return this.text.toString()
}

// To Show Toast
var toast: Toast? = null

fun View.goBack(){
    context?.let { c->
        setOnClickListener {
            (c as? Activity)?.finish()
        }
    }
}

fun AppCompatActivity.showToast(message: String?) {
    if (toast != null) toast!!.cancel()
    toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast?.show()
}

fun showToast(message: String, context: Context) {
    if (toast != null) toast!!.cancel()
    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    toast?.show()
}

fun View.show() {
    this.visibility = View.VISIBLE
}



fun View.hide() {
    this.visibility = View.GONE
}
fun checkCameraAndStoragePermission(context: Context): Boolean {
    var granted = false
    val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )
//    Permissions.check(context, permissions, null, null, object : PermissionHandler() {
//        override fun onGranted() {
//            granted = true
//        }
//
//        override fun onDenied(context: Context?, deniedPermissions: ArrayList<String>?) {
//            granted = false
//        }
//    })
    return granted
}


fun Context.showLogoutDialog(context: Context) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.apply {
        setIcon(R.drawable.ic_launcher_background)
        setTitle("Log Out?")
        setMessage("Are you sure want to log out?")
        setPositiveButton("Logout") { _, _ ->
            var sharedPreference: SharedPreferenceUtil = SharedPreferenceUtil.getInstance(context)

            sharedPreference.isLogin=false

           /* val intent = Intent(context, SplashActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)*/
        }
        setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
    }.create().show()
}



//TimeZone
fun getTimeShow(jointDate: String): String {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val past: Date = format.parse(jointDate)!!
    val currentDate = Date()
    val second: Long = TimeUnit.MILLISECONDS.toSeconds(currentDate.time - past.time)
    val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(currentDate.time - past.time)
    val hours: Long = TimeUnit.MILLISECONDS.toHours(currentDate.time - past.time)
    val days: Long = TimeUnit.MILLISECONDS.toDays(currentDate.time - past.time)
    val month: Double = (days.toDouble() / 30)
    val properMonth = DecimalFormat("##.#").format(month)

    when {
        second < 60 -> {
            return "$second second ago"
        }

        minutes < 60 -> {
            return "$minutes minute ago"
        }

        hours < 24 -> {
            return "$hours hour ago"
        }

        days < 30 -> {
            return "$days day ago"
        }

        month < 12 -> {
            return "$properMonth month ago"
        }

        else -> {
            val year: Int = (month / 12).toInt()
            val properYear = DecimalFormat("##.#").format(year)
            return "$properYear year ago"
        }
    }
}

//EditText is Empty
@RequiresApi(Build.VERSION_CODES.M)
fun EditText.isEditTextEmpty(message: String): Boolean {
    return if (this.getString() == "") {
//        this.error = message
        onSnackToast(this, message)
        this.requestFocus()
        false
    } else
        true
}

//EditText is Empty
@RequiresApi(Build.VERSION_CODES.M)
fun TextView.isEditTextEmpty(message: String): Boolean {
    return if (this.text.toString() == "") {
//        this.error = message
        onSnackToast(this, message)
        this.requestFocus()
        false
    } else
        true
}
//TextView Equal
@RequiresApi(Build.VERSION_CODES.M)
fun TextView.isEqualData(message: String, data:String): Boolean {
    return if (this.text.toString() == message) {
//        this.error = message
        onSnackToast(this, message)
        this.requestFocus()
        false
    } else
        true
}

//Check Valid Email
@RequiresApi(Build.VERSION_CODES.M)
fun EditText.isValidEmailId(email: String): Boolean {
    return if (!Patterns.EMAIL_ADDRESS.matcher(this.text).matches()) {
        onSnackToast(this, email)
        this.requestFocus(this.getString().length)
        false
    } else
        true

}

fun AppCompatActivity.setStatusBarColor() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        // window.setNavigationBarColor(this.resources.getColor(com.android.digestive.R.color.very_light_orange))
        window.statusBarColor = this.resources.getColor(R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

    }
}



@RequiresApi(Build.VERSION_CODES.M)
fun onSnackToast(view: View, message: String) {
    val snackbar = Snackbar.make(
        view, message,
        Snackbar.LENGTH_LONG
    )
    snackbar.setActionTextColor(Color.WHITE)
    val snackbarView = snackbar.view
    snackbarView.setBackgroundColor(Color.WHITE)
    val textView =
        snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    textView.setTextColor(Color.WHITE)
    //textView.setTextAppearance(R.style.Text_Regular_14_White)
    snackbar.show()
}

fun AppCompatActivity.statusBarWhite() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.window.statusBarColor = this.resources.getColor(R.color.white)
        this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

//Check Password Length
@RequiresApi(Build.VERSION_CODES.M)
fun EditText.checkEditTextLength(message: String): Boolean {
    return if (this.getString().length < 8) {
        //this.error = message
        onSnackToast(this, message)
        this.requestFocus(this.getString().length)

        false
    } else
        true
}



//Password Show and Hide
fun EditText.showHidePassword(visible: Boolean) {
    if (visible) {
        this.transformationMethod = HideReturnsTransformationMethod.getInstance()
    } else {
        this.transformationMethod = PasswordTransformationMethod.getInstance()
    }
}
fun String.isValidEmail(): Boolean = this.isNotEmpty() &&
        Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun getDate(long: String): String {

    val cal = Calendar.getInstance(Locale.ENGLISH);
    cal.timeInMillis = long.toLong()
    val date = DateFormat.format("dd-MMM-yyyy", cal).toString()
    return date;
}

fun toRequestBody(data: String?): RequestBody? =
    data?.toRequestBody("text/plain".toMediaTypeOrNull())

fun getTimeStampLong(string: String): String {
    val sdf = SimpleDateFormat("dd-MMM-yyyy")
    val date = sdf.parse(string) as Date
    System.out.println("Today is " + date.time)
    return date.time.toString()
}


//Password Matching Function
@RequiresApi(Build.VERSION_CODES.M)
fun EditText.isPasswordMatch(password: String, message: String): Boolean {
    return if (this.getString() != password) {
//        this.error = message
        onSnackToast(this, message)
        this.requestFocus(this.getString().length)
        false
    } else
        true
}

fun showShortToast(msg: String, context: Context?) {
    val toast = Toast.makeText(
        context,
        msg, Toast.LENGTH_SHORT
    )
    toast.show()
}

fun AppCompatActivity.changeStatusBarColor() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val decor = this.window.decorView
        decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

const val IMAGE_MAX_SIZE=1024
fun compressImageFile(context: Context?, pathUri: Uri): File {


    var b: Bitmap? = null
    val realPath: String? = getRealPathFromURI(context!!, pathUri)
    val f: File = File(realPath)
    //Decode image size
    val o: BitmapFactory.Options = BitmapFactory.Options()
    o.inJustDecodeBounds = true
    var fis: FileInputStream
    try {
        fis = FileInputStream(f)
        BitmapFactory.decodeStream(fis, null, o)
        fis.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    var scale = 1
    if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
        scale = Math.pow(
            2.0,
            Math.ceil(
                Math.log(
                    IMAGE_MAX_SIZE / Math.max(
                        o.outHeight,
                        o.outWidth
                    ).toDouble()
                ) / Math.log(0.5)
            )
        ).toInt()
    }
    //Decode with inSampleSize
    val o2: BitmapFactory.Options = BitmapFactory.Options()
    o2.inSampleSize = scale
    try {
        fis = FileInputStream(f)
        b = BitmapFactory.decodeStream(fis, null, o2)
        fis.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    val destFile = File(getImageFilePath())
    try {
        val out: FileOutputStream = FileOutputStream(destFile)
        b?.compress(Bitmap.CompressFormat.PNG, 90, out)
        out.flush()
        out.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
    return destFile
}

fun getRealPathFromURI(context: Context, contentUri: Uri?): String? {
    var contentUri = contentUri
    var cursor: Cursor?
    var filePath: String? = ""
    when (contentUri) {
        null -> return filePath
        else -> {
            val file = File(contentUri.path)
            when {
                file.exists() -> filePath = file.path
            }
            when {
                !TextUtils.isEmpty(filePath) -> return filePath
                else -> {
                    val proj = arrayOf(MediaStore.Images.Media.DATA)
                    when {
                        Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
                            try {
                                val wholeID = DocumentsContract.getDocumentId(contentUri)
                                val id: String
                                when {
                                    wholeID.contains(":") -> id =
                                        wholeID.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                                            .toTypedArray()[1]
                                    else -> id = wholeID
                                }
                                cursor = context.contentResolver.query(
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                    proj,
                                    MediaStore.Images.Media._ID + "='" + id + "'",
                                    null,
                                    null
                                )
                                when {
                                    cursor != null -> {
                                        val columnIndex = cursor.getColumnIndex(proj[0])
                                        when {
                                            cursor.moveToFirst() -> filePath =
                                                cursor.getString(columnIndex)
                                        }
                                        when {
                                            !TextUtils.isEmpty(filePath) -> contentUri =
                                                Uri.parse(filePath)
                                        }
                                    }
                                }
                            } catch (e: IllegalArgumentException) {
                                e.printStackTrace()
                            }
                        }
                    }
                    when {
                        !TextUtils.isEmpty(filePath) -> return filePath
                        else -> {
                            try {
                                cursor = context.contentResolver.query(
                                    contentUri!!,
                                    proj,
                                    null,
                                    null,
                                    null
                                )
                                when {
                                    cursor == null -> return contentUri.path
                                    cursor.moveToFirst() -> filePath =
                                        cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                                }

                                when {
                                    !cursor!!.isClosed -> cursor.close()
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                filePath = contentUri!!.path
                            }

                            when (filePath) {
                                null -> filePath = ""
                            }
                            return filePath
                        }
                    }

                }
            }

        }
    }

}

/*fun askPermission(context: Context, permissionList: Array<String>, listener: MyDialogListener) {
    com.nabinbhandari.android.permissions.Permissions.check(context, permissionList,
        null,
        null,
        object : PermissionHandler() {
            override fun onGranted() {
                listener.onResult(null)
            }
        })
}*/

fun getImageFilePath(): String {
    val file =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/CareerPortalApp")
    if (!file.exists()) {
        file.mkdirs()
    }
    return file.absolutePath + "/IMG_" + System.currentTimeMillis() + ".jpg"
}




 fun convertFormFileToMultipartBody(key: String, file: File?): MultipartBody.Part? = file?.let {
    MultipartBody.Part.createFormData(
        key, it.name,
        it.asRequestBody("image/*".toMediaTypeOrNull())
    )

}

fun convertAudioFileToMultipartBody(key: String, file: File?): MultipartBody.Part? = file?.let {
    MultipartBody.Part.createFormData(
        key, it.name,
        it.asRequestBody("mp3/*".toMediaTypeOrNull())
    )

}

fun convertFormFileToMultipartBodyList(key: String, file: ArrayList<File>?): ArrayList<MultipartBody.Part>? {

    var list = ArrayList<MultipartBody.Part>()
    for (i in 0 until file?.size!!) {
        list.add(file!![i].let {
            MultipartBody.Part.createFormData(
                key, it.name,
                it.asRequestBody("image/*".toMediaTypeOrNull())
            )

        })
    }
    return list
}



fun AppCompatActivity.getImageUri(inImage: Bitmap): Uri {
    val bytes = ByteArrayOutputStream()
    inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(
        this.contentResolver, inImage,
        "IMG_${System.currentTimeMillis()}", null
    )
    return Uri.parse(path)
}

fun hideKeyboard(activity: Activity) {
    val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view = activity.currentFocus
    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}