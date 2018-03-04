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

    class API {
        static final String ROOT = "/api";

        static final String LOGIN = "/login";
        static final String LOGOUT = "/logout";

        static final String CART = "/cart";
        static final String UPDATE_CART_ITEM_COUNT = "/updateCount";
        static final String DELETE_CART_ITEM = "/delete";
        static final String CLEAR_CART = "/clear";
        static final String ORDER = "/order";

        static final String DELETE_GOODS = "/deleteGoods";
        static final String ADD_GOODS = "/add";
        static final String MODIFY_GOODS = "/modify";
    }
}
