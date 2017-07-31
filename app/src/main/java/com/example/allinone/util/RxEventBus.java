package com.example.allinone.util;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by katakin on 22/07/17.
 */

public class RxEventBus {

    private final PublishSubject<Object> mBusSubject;

    public RxEventBus() {
        mBusSubject = PublishSubject.create();
    }

    /**
     * Posts an object (usually an Event) to the bus
     */
    public void post(Object event) {
        mBusSubject.onNext(event);
    }

    /**
     * Observable that will emmit everything posted to the event bus.
     */
    public Observable<Object> observable() {
        return mBusSubject;
    }

    /**
     * Observable that only emits events of a specific class.
     * Use this if you only want to subscribe to one type of events.
     */
    public <T> Observable<T> filteredObservable(final Class<T> eventClass) {
        return mBusSubject.ofType(eventClass);
    }
}
