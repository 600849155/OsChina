package com.example.administrator.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.oschina.R;
import com.example.administrator.oschina.adapter.MyListViewAdapter;
import com.example.administrator.oschina.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-8-3.
 */
public class ListViewFragment extends Fragment {


    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //这里建一个List用来存放News新闻类
        final List<News> list = new ArrayList<>();
        //创建了个ListView变量用来获取layout中的ListView
        ListView lv1 = (ListView) getView().findViewById(R.id.list_view);
        //建一个适配的变量，将上下文和list加载到ListVIew的适配器中，然后放到适配器变量里
        MyListViewAdapter ma = new MyListViewAdapter(getActivity(),list);
        //将适配器变量的内容加载到List里(也就是把那一堆新闻都放了进去)
        lv1.setAdapter(ma);
        //获取Activity里传过来的捆绑数据
        Bundle bundle = getArguments();
        //用来判断是那一中新闻
        if(bundle != null){
            int arg = bundle.getInt("arg");
            switch (arg){
                case 1:
                    for(int i = 1;i<20;i++){
                        list.add(new News("暴走大事件","刚刚",R.mipmap.mei02,
                                R.mipmap.mei02,R.mipmap.mei02,R.mipmap.mei02 ));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 2:
                    for(int i = 1;i<20;i++){
                        list.add(new News("暴走大事件","刚刚",R.mipmap.mei02,
                                R.mipmap.mei02,R.mipmap.mei02,R.mipmap.mei02));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 3:
                    for(int i = 1;i<20;i++){
                        list.add(new News("推理要在晚饭后","昨天",R.mipmap.mei02,
                                R.mipmap.mei02,R.mipmap.mei02,R.mipmap.mei02));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 4:
                    for(int i = 1;i<20;i++){
                        list.add(new News("嘿嘿嘿~","晚上",R.mipmap.mei02,
                                R.mipmap.mei02,R.mipmap.mei02,R.mipmap.mei02));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 5:
                    for(int i = 1;i<20;i++){
                        list.add(new News("- -、守望","凌晨2点",R.mipmap.mei02,
                                R.mipmap.mei02,R.mipmap.mei02,R.mipmap.mei02));
                    }
                    ma.notifyDataSetChanged();
                    break;
                default:break;
            }
        }

        //这里用到了监听事件，目的是点击新闻列表中的新闻后跳转到完整的新闻界面
//        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                News news = list.get(i);
//                Toast.makeText(getActivity(),news.getTitle(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), IntentActivity.class);
//                intent.putExtra("obj",news);
//                Bundle bundle1 = new Bundle();
//                bundle1.putString("arg1","新闻详情");
//                intent.putExtra("bundle",bundle1);
//                startActivity(intent);
//            }
//        });
    }
}