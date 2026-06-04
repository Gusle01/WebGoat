// [가정] 이 코드는 UserServiceTest.java의 테스트 메서드 내부에 위치합니다.
// [가정] 테스트용 패스워드는 환경변수 또는 시스템 프로퍼티로 주입됩니다.
// [가정] 테스트 환경에서 환경변수 'TEST_USER_PASSWORD'가 설정되어 있어야 합니다.

// 방법 1: 환경변수에서 읽기 (권장 - CI/CD 환경에 적합)
var password = System.getenv("TEST_USER_PASSWORD");
if (password == null || password.isBlank()) {
    throw new IllegalStateException(
        "필수 환경변수 'TEST_USER_PASSWORD'가 설정되지 않았습니다. " +
        "테스트 실행 전 환경변수를 설정하세요."
    );
}

// 방법 2: 시스템 프로퍼티에서 읽기 (JVM 옵션 -DTEST_USER_PASSWORD=... 으로 주입)
// var password = System.getProperty("TEST_USER_PASSWORD");
// if (password == null || password.isBlank()) {
//     throw new IllegalStateException(
//         "필수 시스템 프로퍼티 'TEST_USER_PASSWORD'가 설정되지 않았습니다."
//     );
// }