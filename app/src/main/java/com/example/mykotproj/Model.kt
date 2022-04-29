package com.example.mykotproj

object Model {
    data class Result(val activity: String, val type: String, val participants: Int, val price: Double, val link: String, val key: Int, val accessibility: Double)
}

//{"val type":"education","participants":1,"price":0,"link":"","key":"8926492","accessibility":0.1}
//{
//        "ns": 0,
//        "title": "Incel",
//        "pageid": 57379245,
//        "size": 149549,
//        "wordcount": 13388,
//        "snippet": "Ontario, Alek <span class=\"searchmatch\">Minassian</span> was convicted of 10 counts of first-degree murder and 16 counts of attempted murder. Shortly before the attack, <span class=\"searchmatch\">Minassian</span> had allegedly",
//        "timestamp": "2022-04-09T08:40:15Z"
//      }

