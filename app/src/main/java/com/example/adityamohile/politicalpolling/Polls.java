package com.example.adityamohile.politicalpolling;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aditya Mohile on 8/5/2017.
 */

public class Polls {

    @SerializedName("id")
    public int id;

    @SerializedName("question")
    public String question;

    @SerializedName("description")
    public String description;

    @SerializedName("template_id")
    public int template_id;

    @SerializedName("category_id")
    public int category_id;

}
