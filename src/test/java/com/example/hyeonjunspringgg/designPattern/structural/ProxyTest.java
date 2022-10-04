package com.example.hyeonjunspringgg.designPattern.structural;

interface ServiceEx {
    String runService();
}

class ServiceImpl implements ServiceEx {

    @Override
    public String runService() {
        return null;
    }
}

class Proxy implements  ServiceEx {
    ServiceEx serviceEx;

    @Override
    public String runService() {
        //무언가 추가 ㄴㅇㄹㅁㄹㅁㄹㅉㄸ!
        serviceEx = new ServiceImpl();
        return serviceEx.runService();
    }
}

public class ProxyTest {
}
