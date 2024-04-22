package com.example.beforeigo.utils


import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.app.ActivityCompat
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.internal.Intrinsics

//var toast: Toast? = null

fun hideKeyboard(context: Context?) {
    if (context is Activity) {
        val focusedView = context.currentFocus
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            focusedView?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}

//fun EditText.getString():String = this.text.toString().trim()

fun getDelieveryDate(bookingDate: String): String? {
    Intrinsics.checkParameterIsNotNull(bookingDate, "bookingDate")
    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH)
    val output = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
    var d: Date? = null
    try {
        d = input.parse(bookingDate)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    val formatted = output.format(d)
    val sb = StringBuilder()
    sb.append("")
    sb.append(formatted)
    Log.i("DATE", sb.toString())
    return formatted
}

/*
fun Fragment.showToast(message: String) {
    if (toast != null) toast!!.cancel()
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
}

fun ViewModel.showToast(context: Context?, message: String) {
    if (toast != null) toast!!.cancel()
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showToast(message: String) {
    if (toast != null) toast!!.cancel()
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}*/

fun containsIgnoreCase(str: String?, searchStr: String?): Boolean {
    if (str == null || searchStr == null) return false

    val length = searchStr.length
    if (length == 0)
        return true

    for (i in str.length - length downTo 0) {
        if (str.regionMatches(i, searchStr, 0, length, ignoreCase = true))
            return true
    }
    return false
}

fun getMultiPartyObjects(strVal: String): RequestBody {

    return strVal.toRequestBody("text/plain".toMediaTypeOrNull())
}


var gson: Gson? = null


fun getGsonInstance(): Gson {
    if (gson == null)
        gson = Gson()
    return gson!!
}

/*val String.PasswordValidation: Boolean
    get() = if (this.length < 6 || this.length > 15)
        false
    else {
        this.matches(IntentConstant.Password_Validation.toRegex())
    }


val String.isValidPassword: Boolean
    get() = if (this.length < 8 || this.length > 15)
        false
    else {
       // this.matches(IntentConstant.PASSWORD_PATTERN.toRegex())
    }



val String.isValidEmail: Boolean
    get() = if (this.length < 3 || this.length > 265)
        false
    else {
        this.matches(IntentConstant.EMAIL_PATTERN.toRegex())
    }*/

val String.isValidMobile: Boolean
    get() = this.length in 6..18


/*@SuppressLint("ClickableViewAccessibility")
fun EditText.drawableClickedEditText(onCheckClicked: ClickLeftAndRightListener, positi: Int) {

    this.setOnTouchListener { v, event ->
        var hasConsumed = false
        if (v is TextView) {
            if (event.x <= v.totalPaddingLeft) {

                hasConsumed = true
                if (event.action == MotionEvent.ACTION_UP) {
                    onCheckClicked.click(com.example.verifiedmarketplace.utils.LEFT, positi)
                }
            } else if (event.x >= v.width - v.totalPaddingRight) {

                hasConsumed = true
                if (event.action == MotionEvent.ACTION_UP) {
                    onCheckClicked.click(com.example.verifiedmarketplace.utils.RIGHT, positi)
                }
            }
        }
        hasConsumed
    }

}*/


fun enterAccountNumber(editText: EditText) {
    var preStringSize = 0
    editText.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            val space = p0.toString().length - p0.toString().replace(" ", "").length + 1

            if (preStringSize < p0.length) {
                if (p0.length == 4 * space + space) {
                    editText.setText("${p0.subSequence(0, p0.length - 1)} ${p0[p0.length - 1]}")
                    editText.setSelection(p0.length + 1)

                }
                preStringSize = p0.length
            } else {
                preStringSize = if (p0.isNotEmpty() && p0[p0.length - 1].toString() == " ") {
                    editText.setText("${p0.subSequence(0, p0.length - 1)}")
                    editText.setSelection(p0.length - 1)
                    p0.length - 1

                } else
                    p0.length
            }

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.e("no", "change")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.e("no", "change")
        }
    })
}


fun dateConvertIntoTimeStamp(dob: String): String {
    val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy")
    val date = formatter.parse(dob.replace(" ", "")) as Date
    return date.time.toString()
}

interface DayOFBirthListener {
    fun getDate(dob: String, dobTimeStamp: String)
}


/*fun datePickerDOB(context: Context, sendDOB: DayOFBirthListener) {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val dpd = DatePickerDialog(
        context, R.style.Theme_Holo_Light_Dialog_MinWidth,

        DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
            var tempMonth = mMonth + 1
            var tempDay = mDay

            if (tempMonth > 9) {
                if (tempDay > 9)
                    sendDOB.getDate(
                        "$mDay/${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("$mDay/${tempMonth}/$mYear")
                    )
                else
                    sendDOB.getDate(
                        "0${mDay}/${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("0${mDay}/${tempMonth}/$mYear")
                    )
            } else {
                if (tempDay > 9)
                    sendDOB.getDate(
                        "$mDay/0${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("$mDay/0${tempMonth}/$mYear")
                    )
                else
                    sendDOB.getDate(
                        "0${mDay}/0${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("0${mDay}/0${tempMonth}/$mYear")
                    )
            }
        },
        year,
        month,
        day
    )
    dpd.datePicker.maxDate = Date().time
    dpd.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dpd.show()
}*/

fun datePicker(context: Context, sendDOB: DayOFBirthListener, startingTime: Long) {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val dpd = DatePickerDialog(
        context,
        DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
            var tempMonth = mMonth + 1
            var tempDay = mDay

            if (tempMonth > 9) {
                if (tempDay > 9)
                    sendDOB.getDate(
                        "$mDay/${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("$mDay/${tempMonth}/$mYear")
                    )
                else
                    sendDOB.getDate(
                        "0${mDay}/${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("0${mDay}/${tempMonth}/$mYear")
                    )
            } else {
                if (tempDay > 9)
                    sendDOB.getDate(
                        "$mDay/0${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("$mDay/0${tempMonth}/$mYear")
                    )
                else
                    sendDOB.getDate(
                        "0${mDay}/0${tempMonth}/$mYear",
                        dateConvertIntoTimeStamp("0${mDay}/0${tempMonth}/$mYear")
                    )
            }
        },
        year,
        month,
        day
    )
    //dpd.datePicker.maxDate = startingTime
//    dpd.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dpd.show()
}

/*
fun Context.timePicker(sendDOB: DayOFBirthListener) {
    this.apply {
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
        val minute = mcurrentTime[Calendar.MINUTE]
        val mTimePicker: android.app.TimePickerDialog = android.app.TimePickerDialog(
            this, R.style.TimePickerTheme,
            { timePicker, selectedHour, selectedMinute ->
                if (selectedMinute < 10) {
                    sendDOB.getDate(
                        "$selectedHour:0$selectedMinute",

                        getTimeConvertIntoTimeStamp(
                            selectedHour,
                            selectedMinute
                        )
                    )
                } else {
                    sendDOB.getDate(
                        "$selectedHour:$selectedMinute",
                        getTimeConvertIntoTimeStamp(
                            selectedHour,
                            selectedMinute
                        )
                    )
                }
            },
            hour,
            minute,
            true
        ) //Yes 24 hour time
        mTimePicker.show()
    }
}
*/

fun getTimeConvertIntoTimeStamp(hour: Int, min: Int): String =
    "${(hour * 60 * 60 * 1000) + (min * 60 * 1000)}"


fun getDeviceIdFromApp(context: Context): String? {
    var deviceId: String
    deviceId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val date = Date()
        val timeMilli = date.time
        timeMilli.toString()
    } else {
        val mTelephony = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
        if (mTelephony.deviceId.toString().isNotEmpty()) {
            mTelephony.deviceId
        } else {
            Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        }
    }
    return deviceId
}