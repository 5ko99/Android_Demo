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

public class CreateEntry  {


    public static   void createEntry(EverliveApp myApp, String name, int age){

        CommonTable commonTable = new CommonTable();
        commonTable.setName("Ivan");
        commonTable.setAge(age);
        myApp.workWith().data(CommonTable.class).create(commonTable).executeAsync(new RequestResultCallbackAction<ArrayList<CommonTable>>() {
            @Override
            public void invoke(RequestResult<ArrayList<CommonTable>> requestResult) {
                if(requestResult.getSuccess()){
                    for (CommonTable res  : requestResult.getValue()) {

                    }

                }else{

                }
            }
        });
    }
}
*/
