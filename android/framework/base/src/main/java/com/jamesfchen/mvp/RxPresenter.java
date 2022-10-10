package com.jamesfchen.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Copyright ® $ 2017
 * All right reserved.
 * Code Link : https://github.com/HawksJamesf/Spacecraft
 *
 * @author: jamesfchen
 * @since: 1/24/18
 */

public abstract class RxPresenter<V> {

    protected V view;

    private CompositeDisposable disposable;


    void removeSubscriber() {
        if (disposable != null) {
            disposable.clear();

        }
    }

    protected void addsubscriber(Disposable d) {
        if (disposable == null) {
            disposable = new CompositeDisposable();
        }
        disposable.add(d);

    }

    protected void onAttach(V view) {
        this.view = view;

    }

    protected void onDetach() {
        this.view = null;
        removeSubscriber();

    }
}
