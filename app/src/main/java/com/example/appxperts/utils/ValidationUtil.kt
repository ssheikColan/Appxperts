package com.example.appxperts.utils

import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by MI-062 on 22/1/18.
 */

/**
 * PASSWORD_PATTERN = "((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
 * (			    #   Start of group
 * (?=.*\d)		    #   must contains one digit from 0-9
 * (?=.*[a-z])		#   must contains one lowercase characters
 * (?=.*[A-Z])		#   must contains one uppercase characters
 * (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
 * .        		#   match anything with previous condition checking
 * {6,20}	        #   length at least 6 characters and maximum of 20
 * )    			#   End of group
 */

val PASSWORD_PATTERN = Pattern.compile("((?=.*\\d)(?=.*[a-zA-Z]).{6,})")

fun String.isRequiredField(): Boolean {
    return isNotEmpty() && isNotBlank()
}

fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidMobile(): Boolean {
    return this.length > 6
}

fun String.isValidPassword(): Boolean {
    return PASSWORD_PATTERN.matcher(this).matches()
}

fun String.getValidString(): String {
    return this.trim()
}

fun getDoubleFromString(strText: String): Double {
    if (strText.isRequiredField()) {
        try {
            return java.lang.Double.parseDouble(strText)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    return 0.0
}

fun String.isValidateUserName():Boolean{
    val format = Pattern.compile(
            "^[-\$&+,_:;=\\\\\\\\?@#|/'<>.^*()%!-,~@\"]+$" + "^\\d"
    )

    return format.matcher(this).matches()
}