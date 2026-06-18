// [가정 1] 이 코드는 테스트 코드(UserServiceTest.java)이므로,
//          테스트 환경에서 환경변수 또는 시스템 프로퍼티로 패스워드를 주입받는 방식으로 수정합니다.
// [가정 2] 환경변수명은 "TEST_USER_PASSWORD"로 가정합니다. 실제 환경에 맞게 변경하세요.
// [가정 3] 환경변수가 설정되지 않은 경우 테스트를 명시적으로 실패시켜 안전하게 처리합니다.

String password = System.getenv("TEST_USER_PASSWORD");
if (password == null || password.isBlank()) {
    // 시스템 프로퍼티 fallback (예: -DTEST_USER_PASSWORD=... 로 JVM 실행 시)
    password = System.getProperty("TEST_USER_PASSWORD");
}
if (password == null || password.isBlank()) {
    throw new IllegalStateException(
        "필수 환경변수 'TEST_USER_PASSWORD'가 설정되지 않았습니다. " +
        "환경변수 또는 JVM 시스템 프로퍼티(-DTEST_USER_PASSWORD)를 설정하세요."
    );
}