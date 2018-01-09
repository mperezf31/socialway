package com.caminosantiago.socialway.model.query;

import com.google.gson.annotations.SerializedName;
import com.caminosantiago.socialway.model.Publication;
import com.caminosantiago.socialway.model.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by root on 17/10/2015.
 */
public class ListPublications implements Serializable {

    @SerializedName("status")
    String status;

    @SerializedName("favourites")
    List<Integer> favourites;

    @SerializedName("header")
    List<User> header;

    @SerializedName("listPublication")
    List<Publication> listPublication;

    public String getStatus() {
        return status;
    }

    public List<Integer> getFavourites() {
        return favourites;
    }

    public List<Publication> getListPublication() {
        return listPublication;
    }

    public List<User> getHeader() {
        return header;
    }



}