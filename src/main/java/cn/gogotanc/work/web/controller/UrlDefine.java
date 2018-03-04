package cn.gogotanc.work.web.controller;

/**
 * @author tanc
 */
class UrlDefine {

    class Main {

        static final String ROOT = "/";
        static final String INDEX = ROOT;
        static final String MESSAGE = "/message";
        static final String DETAIL = "/detail";
        static final String LOGIN = "/login";
    }

    class Buyer {
        static final String CART = "/cart";
        static final String FINANCE = "/finance";
    }

    class Seller {
        static final String ADD = "/add";
        static final String MODIFY = "/modify";
    }
}
