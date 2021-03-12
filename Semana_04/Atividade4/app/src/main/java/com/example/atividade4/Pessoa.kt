package layout

import android.os.Parcel
import android.os.Parcelable

class Pessoa(var ano: Int, var nome: String) : Parcelable {

    constructor(parcel: Parcel) : this(0, "") {
        nome = parcel.readString().toString()
        ano = parcel.readInt()
    }

    constructor(nome: String, ano: Int) : this(0, "") {
        this.nome = nome
        this.ano = ano
    }
    fun idade(): Int{
        return 2021 - this.ano
    }

    override fun toString(): String {
        return this.nome + " - " + this.ano
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeInt(ano)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pessoa> {
        override fun createFromParcel(parcel: Parcel): Pessoa {
            return Pessoa(parcel)
        }

        override fun newArray(size: Int): Array<Pessoa?> {
            return arrayOfNulls(size)
        }
    }
}