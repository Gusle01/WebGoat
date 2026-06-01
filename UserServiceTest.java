// [가정] 이 코드는 UserServiceTest.java의 테스트 메서드 내부에 위치합니다.
// [가정] 테스트 환경에서 환경변수 또는 시스템 프로퍼티로 패스워드를 주입받습니다.
// [가정] 테스트 프레임워크는 JUnit이며, 실제 인증 로직을 검증하는 테스트입니다.

// 1순위: 환경변수에서 패스워드 로드
// 환경변수 설정 예시: export TEST_USER_PASSWORD=your_test_password
// 또는 시스템 프로퍼티: -DTEST_USER_PASSWORD=your_test_password (JVM 옵션)
var password = System.getenv("TEST_USER_PASSWORD") != null
        ? System.getenv("TEST_USER_PASSWORD")
        : System.getProperty("TEST_USER_PASSWORD");

if (password == null || password.isBlank()) {
    throw new IllegalStateException(
        "테스트 패스워드가 설정되지 않았습니다. " +
        "환경변수 'TEST_USER_PASSWORD' 또는 " +
        "JVM 시스템 프로퍼티 '-DTEST_USER_PASSWORD'를 설정하세요."
    );
}