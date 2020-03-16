package com.example.l3t2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portals(
    public var portalName: String,
    public var PortalURL: String
): Parcelable
{
    companion object {
        val UrlName = arrayOf(
            "Mijn HVA"
        )
        val UrlLink = arrayOf(
            "https://fdmci.mijnhva.nl"

        )
    }
}
