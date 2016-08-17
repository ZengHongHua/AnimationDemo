package com.cnpay.animationdemo;

/**
 * 包   名:     com.cnpay.animationdemo
 * 版权所有:     版权所有(C)2010-2016
 * 版   本:          V1.0
 * 时   间:     2016/8/16 0016 17:13
 * 作   者:     zenghonghua
 */
public interface Config {

    //网络图片地址
    String[] IMAGES = new String[]{
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/21/110000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/044000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/21/110000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/052000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/29/080000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/094000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/081000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/081000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/094000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/29/102000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/21/110000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/044000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/21/110000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/052000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/29/080000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/094000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/081000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/081000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/094000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/29/102000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/095000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/21/110000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2016/01/04/044000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/21/110000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/24/052000_0_0.png",
            "http://res.cloudinary.com/liuyuesha/image/fetch/http://himawari8-dl.nict.go.jp/himawari8/img/D531106/1d/550/2015/12/29/080000_0_0.png"
    };
}
