/*
package com.example.aoc.telerikbeckend.WorkingWithTelerikBeckendServices;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.aoc.telerikbeckend.Data.CommonTable;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;


public class GetAllEntrys {


    public static ArrayList<String> getAllEntrys(EverliveApp myApp) {
        final ArrayList<String> arr = new ArrayList<String>();
        myApp.workWith().data(CommonTable.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<CommonTable>>() {
            @Override
            public void invoke(RequestResult<ArrayList<CommonTable>> requestResult) {
                if(requestResult.getSuccess()){
                    for (   CommonTable res  : requestResult.getValue()) {
                        arr.add(res.getName().toString());
                        arr.add((Integer.toString(res.getAge())));
                    }

                }else{

                }

            }

        });
        return arr;
    }
}
*/
