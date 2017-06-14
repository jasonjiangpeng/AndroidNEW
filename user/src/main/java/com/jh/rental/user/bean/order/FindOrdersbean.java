package com.jh.rental.user.bean.order;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/14.
 */

public class FindOrdersbean {

    /**
     * pageNum : 1
     * pageSize : 10
     * size : 10
     * orderBy : null
     * startRow : 1
     * endRow : 10
     * total : 148
     * pages : 15
     * list : [{"id":"20170608153522000013","service_type":1,"sys_service_type":null,"code":"jh1496907321419","createTime":1496907322000,"name":null,"begin_time":1497337772000,"model":null,"brand":null,"number":"3","begin_address":"201路;226路;332路;362路;E24路;M209路;M240路;M343路;M355路;M475路;T2A路/大运城邦-深圳湾口岸专线;高峰专线72路","end_address":"2号线/蛇口线","visa_type":2,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":"900.00","is_ret":null,"status2":2,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608100933000003","service_type":2,"sys_service_type":null,"code":"jh1496887772627","createTime":1496887773000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"1","begin_address":"华强北路2005号茂业百货(华强北店)L7层","end_address":"华强北路3005号附近","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608100949000004","service_type":2,"sys_service_type":null,"code":"jh1496887788621","createTime":1496887789000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"1","begin_address":"华强北路2005号茂业百货(华强北店)L7层","end_address":"华强北路3005号附近","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608101016000007","service_type":2,"sys_service_type":null,"code":"jh1496887815619","createTime":1496887816000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"1","begin_address":"华强北路2005号茂业百货(华强北店)L7层","end_address":"华强北路3005号附近","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608112930000001","service_type":2,"sys_service_type":null,"code":"jh1496892569283","createTime":1496892570000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"1","begin_address":"华强北路2005号茂业百货(华强北店)L6层","end_address":"华强北路3005号附近","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608134559000001","service_type":2,"sys_service_type":null,"code":"jh1496900757791","createTime":1496900759000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"3","begin_address":"华强北路2005号茂业百货(华强北店)L2层","end_address":"华强北路2005号茂业百货(华强北店)B1层","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608140344000003","service_type":2,"sys_service_type":null,"code":"jh1496901824012","createTime":1496901824000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"2","begin_address":"华强北路2005号茂业百货(华强北店)L6层","end_address":"华强北路2009号茂业百货华强北店5层","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608140445000005","service_type":2,"sys_service_type":null,"code":"jh1496901883863","createTime":1496901885000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"3","begin_address":"华强北路2005号茂业百货(华强北店)L1层","end_address":"振兴西路港澳城后面佳年外贸城2楼","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608140514000007","service_type":2,"sys_service_type":null,"code":"jh1496901913386","createTime":1496901914000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"3","begin_address":"华强北路2005号茂业百货(华强北店)L1层","end_address":"振兴西路港澳城后面佳年外贸城2楼","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null},{"id":"20170608140542000009","service_type":2,"sys_service_type":null,"code":"jh1496901942056","createTime":1496901942000,"name":null,"begin_time":1497337510000,"model":null,"brand":null,"number":"2","begin_address":"华强北路与振兴路交叉口西100米","end_address":"华强北路与振兴路交叉口西100米","visa_type":null,"pass_port":null,"type":null,"status":100,"statusName":"待付款","nick_name":"x","price_sum":null,"is_ret":null,"status2":null,"package_time":10,"mobile":null,"fly_no":null,"pick_time":null,"off_time":null}]
     * prePage : 0
     * nextPage : 2
     * isFirstPage : true
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : true
     * navigatePages : 8
     * navigatepageNums : [1,2,3,4,5,6,7,8]
     * navigateFirstPage : 1
     * navigateLastPage : 8
     * firstPage : 1
     * lastPage : 8
     */

    private int pageNum;
    private int pageSize;
    private int size;
    private Object orderBy;
    private int startRow;
    private int endRow;
    private int total;
    private int pages;
    private int prePage;
    private int nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private int navigateFirstPage;
    private int navigateLastPage;
    private int firstPage;
    private int lastPage;
    private List<ListBean> list;
    private List<Integer> navigatepageNums;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Object orderBy) {
        this.orderBy = orderBy;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<Integer> getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public static class ListBean {
        /**
         * id : 20170608153522000013
         * service_type : 1
         * sys_service_type : null
         * code : jh1496907321419
         * createTime : 1496907322000
         * name : null
         * begin_time : 1497337772000
         * model : null
         * brand : null
         * number : 3
         * begin_address : 201路;226路;332路;362路;E24路;M209路;M240路;M343路;M355路;M475路;T2A路/大运城邦-深圳湾口岸专线;高峰专线72路
         * end_address : 2号线/蛇口线
         * visa_type : 2
         * pass_port : null
         * type : null
         * status : 100
         * statusName : 待付款
         * nick_name : x
         * price_sum : 900.00
         * is_ret : null
         * status2 : 2
         * package_time : 10
         * mobile : null
         * fly_no : null
         * pick_time : null
         * off_time : null
         */

        private String id;
        private int service_type;
        private Object sys_service_type;
        private String code;
        private long createTime;
        private Object name;
        private long begin_time;
        private Object model;
        private Object brand;
        private String number;
        private String begin_address;
        private String end_address;
        private int visa_type;
        private Object pass_port;
        private Object type;
        private int status;
        private String statusName;
        private String nick_name;
        private String price_sum;
        private Object is_ret;
        private int status2;
        private int package_time;
        private Object mobile;
        private Object fly_no;
        private Object pick_time;
        private Object off_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getService_type() {
            return service_type;
        }

        public void setService_type(int service_type) {
            this.service_type = service_type;
        }

        public Object getSys_service_type() {
            return sys_service_type;
        }

        public void setSys_service_type(Object sys_service_type) {
            this.sys_service_type = sys_service_type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public long getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(long begin_time) {
            this.begin_time = begin_time;
        }

        public Object getModel() {
            return model;
        }

        public void setModel(Object model) {
            this.model = model;
        }

        public Object getBrand() {
            return brand;
        }

        public void setBrand(Object brand) {
            this.brand = brand;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getBegin_address() {
            return begin_address;
        }

        public void setBegin_address(String begin_address) {
            this.begin_address = begin_address;
        }

        public String getEnd_address() {
            return end_address;
        }

        public void setEnd_address(String end_address) {
            this.end_address = end_address;
        }

        public int getVisa_type() {
            return visa_type;
        }

        public void setVisa_type(int visa_type) {
            this.visa_type = visa_type;
        }

        public Object getPass_port() {
            return pass_port;
        }

        public void setPass_port(Object pass_port) {
            this.pass_port = pass_port;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getPrice_sum() {
            return price_sum;
        }

        public void setPrice_sum(String price_sum) {
            this.price_sum = price_sum;
        }

        public Object getIs_ret() {
            return is_ret;
        }

        public void setIs_ret(Object is_ret) {
            this.is_ret = is_ret;
        }

        public int getStatus2() {
            return status2;
        }

        public void setStatus2(int status2) {
            this.status2 = status2;
        }

        public int getPackage_time() {
            return package_time;
        }

        public void setPackage_time(int package_time) {
            this.package_time = package_time;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getFly_no() {
            return fly_no;
        }

        public void setFly_no(Object fly_no) {
            this.fly_no = fly_no;
        }

        public Object getPick_time() {
            return pick_time;
        }

        public void setPick_time(Object pick_time) {
            this.pick_time = pick_time;
        }

        public Object getOff_time() {
            return off_time;
        }

        public void setOff_time(Object off_time) {
            this.off_time = off_time;
        }
    }
}
