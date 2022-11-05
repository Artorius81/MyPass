package com.vvsu.mypass.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


lateinit var AUTH : FirebaseAuth
lateinit var REF_DATABASE_ROOT : DatabaseReference

fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
}