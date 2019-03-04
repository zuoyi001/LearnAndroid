package com.ts.testapp;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import android.util.EventLogTags;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.alibaba.fastjson.serializer.SerializerFeature;

import com.ts.testapp.UserInfo;
import com.ts.testapp.Mydialog;

public class MainActivity extends AppCompatActivity {

    private Button Tsbutton;
    private TextView TsText;

    private Button Tsbutton1;

    static public boolean NBool = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tsbutton = findViewById(R.id.TsButton);
        TsText = findViewById(R.id.TsText);
        Tsbutton.setOnClickListener(OnClickListener);

        Tsbutton1 = findViewById(R.id.TsButton1);
        Tsbutton1.setOnClickListener(OnClickListener);
    }

    /**
     *
     */
    private View.OnClickListener OnClickListener;

    {
        OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.TsButton:
//            //1.将Map转换成Json字符串
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("age", "25");
//            map.put("name","张三");
//            map.put("sex", "男");
//            map.put("age", "22");
//            map.put("name","李四");
//            map.put("sex", "女");
//            String mapJson = JSON.toJSONString(map);
//            Log.d("TAG","map2Json----:"+mapJson);

                        //1.Map与Json之间的相互转换
                        HashMap<Object, Object> map = new HashMap<>();
                        map.put("key1", "value1");
                        map.put("key2", "value2");
                        ////序列化
                        String jsonStr = JSON.toJSONString(map);
                        Log.d("TAG", "Map->json: " + jsonStr);    //{"key2":"value2","key1":"value1"}
                        //反序列化
                        Map<String, String> mapFromJson = (Map<String, String>) JSON.parse(jsonStr);
                        String value1 = mapFromJson.get("key1");
                        String value2 = mapFromJson.get("key2");
                        Log.d("TAG", "json->:Map " + "value1->" + value1 + ",value2->" + value2);   //value1->value1,value2->value2

                        //2.Object Class<-->JSON
                        UserInfo userInfo = new UserInfo();
                        userInfo.setAge(30);
                        userInfo.setName("zhang3");
                        String jsonStr2 = JSON.toJSONString(userInfo);
                        Log.d("TAG", "Map->json: " + jsonStr2);    //{"age":30,"username":"name1"}

                        UserInfo userInfoFromJson = JSON.parseObject(jsonStr2, UserInfo.class);
                        Log.d("TAG", "json->:Map: " + "userInfoFromJson.getAge():" + userInfoFromJson.getAge() + ",userInfoFromJson.getName():" + userInfoFromJson.getName());//userInfoFromJson.getAge():30,userInfoFromJson.getName():name1

                        //3.List(Obj)<-->Json
                        UserInfo userInfo1 = new UserInfo();
                        userInfo1.setAge(10);
                        userInfo1.setName("zhang3");
                        UserInfo userInfo2 = new UserInfo();
                        userInfo2.setAge(20);
                        userInfo2.setName("Li4");
                        UserInfo userInfo3 = new UserInfo();
                        userInfo3.setAge(30);
                        userInfo3.setName("Wang5");

                        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
                        userInfoList.add(userInfo1);
                        userInfoList.add(userInfo2);
                        userInfoList.add(userInfo3);
                        String jsonStr3 = JSON.toJSONString(userInfoList);
                        Log.d("TAG", "Map->json: " + jsonStr3);


                        List<UserInfo> userInfoListFromJson = JSON.parseArray(jsonStr3, UserInfo.class);
                        Log.d("TAG", "userInfoListFromJson.size()->" + userInfoListFromJson.size());    //userInfoListFromJson.size()->3

                        for (int i = 0; i < userInfoListFromJson.size(); i++) {
                            UserInfo userInfoTemp = userInfoListFromJson.get(i);
                /*
                 0---> age:10,name:zhang3
                 1---> age:20,name:Li4
                 2---> age:30,name:Wang5
                */
                            Log.d("TAG", "json->:Map:" + i + "--->" + "userInfoTemp, age:" + userInfoTemp.getAge() + ",name:" + userInfoTemp.getName());
                        }


//            String Arraystring="[{\"age\":\"20\",\"name\":\"张三\",\"sex\":\"男\"}," +
//                    "{\"age\":\"22\",\"name\":\"小华\",\"sex\":\"女\"}," +
//                    "{\"age\":\"20\",\"name\":\"小丽\",\"sex\":\"女\"}]";
//
//
//            Log.d("TAG",Arraystring+"");
//
//            com.alibaba.fastjson.JSONArray array= JSON.parseArray(Arraystring);
//
//            int length=array.size();
//
//            for(int i=0;i<length;i++){
//                com.alibaba.fastjson.JSONObject jsonObject=array.getJSONObject(i);
//
//                String ages=jsonObject.getString("age");
//                String names=jsonObject.getString("name");
//                String sexs=jsonObject.getString("sex");
//
//                Log.d("TAG","names----:" + names);
//                Log.d("TAG","ages----:" + ages);
//                Log.d("TAG","sexs----:" + sexs);
//            }

                        if (NBool == true) {
                            Tsbutton.setText("点击了");
                            TsText.setText("按钮点击了");
                            NBool = false;
                        } else {
                            Tsbutton.setText("测试点击");
                            TsText.setText("点击按钮");
                            NBool = true;
                        }
                        break;

                    case R.id.TsButton1:


                        ShowMyDialog();

                        Log.d("TAG", "TsButton1 OnClick----");

                        break;

                    default:
                        break;
                }
            }
        };
    }

    private void ShowMyDialog()
    {
        final LinearLayout myiew = (LinearLayout)LayoutInflater.from(MainActivity.this).inflate(R.layout.mylayout,null);

        final EditText leftEt = myiew.findViewById(R.id.left_eye_res_et);
        final EditText rightEt = myiew.findViewById(R.id.right_eye_res_et);
//        final EditText leftglassEt = myiew.findViewById(R.id.left_glass_eye_res_et);
//        final EditText rightglassEt = myiew.findViewById(R.id.right_glass_eye_res_et);
        final RadioGroup tagRadioGroup = (RadioGroup) myiew.findViewById(R.id.tag_rg);

        final RadioButton squint = (RadioButton) myiew.findViewById(R.id.tag_squint);
        final RadioButton attention = (RadioButton) myiew.findViewById(R.id.tag_attention);

        tagRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                rightEt.setText( ((RadioButton)myiew.findViewById(i)).getText().toString());
                rightEt.setTextSize(14);
                //String output = squint.getText().toString();
                //Toast.makeText(MainActivity.this, "CheackID" + output, Toast.LENGTH_SHORT).show();

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.tag_squint:
                        leftEt.setText("测试1");
                        break;
                    case R.id.tag_attention:
                        leftEt.setText("测试2");
                        break;
                    default:
                        break;
                }
            }
        });

        leftEt.setText("测试");
        myiew.findViewById(R.id.glass_eye_res_ll).setVisibility(View.VISIBLE);
        myiew.findViewById(R.id.eye_res_ll).setVisibility(View.VISIBLE);


        final Mydialog submitDialog = new Mydialog(MainActivity.this);
        submitDialog.setTitleStr("随便显示测试TextView");

        //submitDialog.setCustomView(myiew);
        submitDialog.show();

        submitDialog.getSubmitBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了对话框中的按钮", Toast.LENGTH_SHORT).show();

                submitDialog.dismiss();

                return;
            }
        });
    }

}
