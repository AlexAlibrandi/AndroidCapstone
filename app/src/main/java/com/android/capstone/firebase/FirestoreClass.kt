package com.android.capstone.firebase

import android.util.Log
import com.android.capstone.activities.RegisterActivity
import com.android.capstone.models.User
import com.android.capstone.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: RegisterActivity,userInfo : User){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId()).set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener {
            Log.e(activity.javaClass.simpleName,"Error")
            }
    }

    fun getCurrentUserId(): String{
        return  FirebaseAuth.getInstance().currentUser!!.uid
    }
}