package com.example.appdevelopment

import android.os.Parcel
import android.os.Parcelable

data class CollapsePanel(
    val id: Int,
    val tittle: String,
    val content: String,
    val likes: String,
    val time: String,
    var isExpanded: Boolean = false
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(tittle)
        parcel.writeString(content)
        parcel.writeString(likes)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CollapsePanel> {
        override fun createFromParcel(parcel: Parcel): CollapsePanel {
            return CollapsePanel(parcel)
        }

        override fun newArray(size: Int): Array<CollapsePanel?> {
            return arrayOfNulls(size)
        }
    }
}
