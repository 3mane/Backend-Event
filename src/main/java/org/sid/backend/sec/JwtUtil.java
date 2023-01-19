package org.sid.backend.sec;

public class JwtUtil {
    public static final String SECRET="mySecret1234";
    public static final String Auth_Header="Authorization";
    public static final long EXPIRE_ACCESS_TOKEN=7*60*1000;
    public static final long EXPIRE_REFRESH_TOKEN=15*60*1000;
    public static final String PREFIX="Bearer ";



}
