package risesmj.com.br.mydoceasy.data.model

import android.os.Parcel
import android.os.Parcelable
import risesmj.com.br.mydoceasy.R

class DocumentPersonal(
    var title: String? = "",
    var icon: Int = R.drawable.ic_text_snippet,
    var observation: String? = "",
    var pertencente: Int = 0): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }

    companion object CREATOR : Parcelable.Creator<DocumentPersonal> {
        override fun createFromParcel(parcel: Parcel): DocumentPersonal {
            return DocumentPersonal(parcel)
        }

        override fun newArray(size: Int): Array<DocumentPersonal?> {
            return arrayOfNulls(size)
        }
    }

    object PERTENCE{
        val VOCE = 0
        val MAE = 1
        val PAI = 2
    }
}