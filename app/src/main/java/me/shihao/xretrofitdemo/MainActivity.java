package me.shihao.xretrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
import me.shihao.xretrofit.XApi;
import me.shihao.xretrofitdemo.net.GankResults;
import me.shihao.xretrofitdemo.net.NetApi;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        NetApi.getGankService().getGankData("Android", 10, 1)
                .compose(XApi.<GankResults>getObservableScheduler())
                .subscribe(new ResourceObserver<GankResults>() {
                    @Override
                    public void onNext(@NonNull GankResults gankResults) {
                        textView.append("\nonNext");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        textView.append("\nonError");
                    }

                    @Override
                    public void onComplete() {
                        textView.append("\nonComplete");
                    }
                });
    }
}
