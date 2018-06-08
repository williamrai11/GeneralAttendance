package com.example.william.sxcattendance.Network.Model;

public class loginModel {


    /**
     * data : {"user_name":"kk","email":"kk@gmail.com","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjU3MDdlZDQxMTE0ZTNiOWZjMjEwODVhZjA4ZjgyMTkwYmM1ZWYzYWU3NThiYzM5N2I2ZjE2ZTA3M2E2MzkzOTY4MTQxMzk3MGE5OGMzZTU4In0.eyJhdWQiOiIxIiwianRpIjoiNTcwN2VkNDExMTRlM2I5ZmMyMTA4NWFmMDhmODIxOTBiYzVlZjNhZTc1OGJjMzk3YjZmMTZlMDczYTYzOTM5NjgxNDEzOTcwYTk4YzNlNTgiLCJpYXQiOjE1MjY0NDU0MjQsIm5iZiI6MTUyNjQ0NTQyNCwiZXhwIjoxNTU3OTgxNDI0LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.HDTixjw88vvcDSDiXGt3pgzm0VAZ-MGR7eK5IHBhXdS1lEBszqgRHGP4NHjCD1krNEmlcILJEwG9VAW0sF3XFbRPata53spEzJOqQU0mvo--ogz8ILqjvcUA2bNzs_ikCbw3DTUGMUSSTZ1DOnFEU0ANuXDwUQP3yIFxOzM84FYRJ98MF3TwieIR35TsFXdBIk4yOHilVy7OCaVSU-Yd73JBzx2UEYf_P5x4YmFJ8d5QwuvPsi024fTPOSo4B0FcdJ-Pc4U-cJJ6vQfump-rDnVibNwGbIxPiM1eIUy722XutkBCTlA2RrFdrHrTU55vPohRxAwM8asJ4WDcErLG6cp65Ud9gV--2oYGclQsxckPYljdy4hW2OaBEEA5m8DuArikvHzLpMcW3AFybHuwhqIvwj2PmJ0IXJH2k0r6V2mX2yXgVXzTg0sxfsrPpwGxKXKhyQjT2cioJCZUJeF5wikxRx28LjoLqkdBltWB5MRG3Xh4k-v-JopcO-awTMNQrMk_OPWU-snIwdkH8SMuvUVGETD1AdK0qLCYRHKyXKIG95Ey1Nt0i236bpaxVmJuQsT3r-eRftJ3lJMLBWTbUbGAvGzQIMDGG05StV2cSpP9Q6TXi4ap4wn7Z6eavRSbNG6K05XXEbM30Ka8kv4rj5_zYhU_DdzjFGyEKOc_GS4","expires_at":"2019-05-16"}
     * code : 200
     */

    private DataBean data;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * user_name : kk
         * email : kk@gmail.com
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjU3MDdlZDQxMTE0ZTNiOWZjMjEwODVhZjA4ZjgyMTkwYmM1ZWYzYWU3NThiYzM5N2I2ZjE2ZTA3M2E2MzkzOTY4MTQxMzk3MGE5OGMzZTU4In0.eyJhdWQiOiIxIiwianRpIjoiNTcwN2VkNDExMTRlM2I5ZmMyMTA4NWFmMDhmODIxOTBiYzVlZjNhZTc1OGJjMzk3YjZmMTZlMDczYTYzOTM5NjgxNDEzOTcwYTk4YzNlNTgiLCJpYXQiOjE1MjY0NDU0MjQsIm5iZiI6MTUyNjQ0NTQyNCwiZXhwIjoxNTU3OTgxNDI0LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.HDTixjw88vvcDSDiXGt3pgzm0VAZ-MGR7eK5IHBhXdS1lEBszqgRHGP4NHjCD1krNEmlcILJEwG9VAW0sF3XFbRPata53spEzJOqQU0mvo--ogz8ILqjvcUA2bNzs_ikCbw3DTUGMUSSTZ1DOnFEU0ANuXDwUQP3yIFxOzM84FYRJ98MF3TwieIR35TsFXdBIk4yOHilVy7OCaVSU-Yd73JBzx2UEYf_P5x4YmFJ8d5QwuvPsi024fTPOSo4B0FcdJ-Pc4U-cJJ6vQfump-rDnVibNwGbIxPiM1eIUy722XutkBCTlA2RrFdrHrTU55vPohRxAwM8asJ4WDcErLG6cp65Ud9gV--2oYGclQsxckPYljdy4hW2OaBEEA5m8DuArikvHzLpMcW3AFybHuwhqIvwj2PmJ0IXJH2k0r6V2mX2yXgVXzTg0sxfsrPpwGxKXKhyQjT2cioJCZUJeF5wikxRx28LjoLqkdBltWB5MRG3Xh4k-v-JopcO-awTMNQrMk_OPWU-snIwdkH8SMuvUVGETD1AdK0qLCYRHKyXKIG95Ey1Nt0i236bpaxVmJuQsT3r-eRftJ3lJMLBWTbUbGAvGzQIMDGG05StV2cSpP9Q6TXi4ap4wn7Z6eavRSbNG6K05XXEbM30Ka8kv4rj5_zYhU_DdzjFGyEKOc_GS4
         * expires_at : 2019-05-16
         */

        private String user_name;
        private String email;
        private String token;
        private String expires_at;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getExpires_at() {
            return expires_at;
        }

        public void setExpires_at(String expires_at) {
            this.expires_at = expires_at;
        }
    }
}
