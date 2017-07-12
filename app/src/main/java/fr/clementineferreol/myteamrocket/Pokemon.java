package fr.clementineferreol.myteamrocket;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by clementineferreol on 20/06/2017.
 */

public class Pokemon implements Parcelable {

    private String name;
    private String type;
    private Integer attack;
    private Integer defense;
    private Integer evolveLevel;
    private String number;
    private ArrayList<String> moves;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Integer getattack() { return attack; }

    public Integer getdefense() { return defense; }

    public Integer getEvolveLevel() { return evolveLevel; }

    public String getNumber() {
        return number;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    protected Pokemon(Parcel in) {
        name = in.readString();
        type = in.readString();
        attack = in.readByte() == 0x00 ? null : in.readInt();
        defense = in.readByte() == 0x00 ? null : in.readInt();
        evolveLevel = in.readByte() == 0x00 ? null : in.readInt();
        number = in.readString();
        if (in.readByte() == 0x01) {
            moves = new ArrayList<String>();
            in.readList(moves, String.class.getClassLoader());
        } else {
            moves = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        if (attack == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(attack);
        }
        if (defense == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(defense);
        }
        if (evolveLevel == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(evolveLevel);
        }
        dest.writeString(number);

        if (moves == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(moves);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pokemon> CREATOR = new Parcelable.Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };


}