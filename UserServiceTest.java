// [가정 1] 이 코드는 UserServiceTest.java의 테스트 메서드 내부에 위치합니다.
// [가정 2] 테스트용 패스워드는 환경변수 또는 시스템 프로퍼티로 주입됩니다.
// [가정 3] 테스트 환경에서는 실제 운영 자격증명을 사용하지 않아야 합니다.

// 방법 1: 환경변수에서 읽기 (운영/스테이징 환경 통합 테스트용)
var password = System.getenv("TEST_USER_PASSWORD");
if (password == null || password.isBlank()) {
    // 방법 2: 시스템 프로퍼티 폴백 (로컬 개발 환경: -DTEST_USER_PASSWORD=... 으로 전달)
    password = System.getProperty("TEST_USER_PASSWORD");
}
if (password == null || password.isBlank()) {
    throw new IllegalStateException(
        "TEST_USER_PASSWORD 환경변수 또는 시스템 프로퍼티가 설정되지 않았습니다. " +
        "테스트 실행 전 환경변수를 설정하거나 -DTEST_USER_PASSWORD=<value> 옵션을 사용하세요."
    );
}