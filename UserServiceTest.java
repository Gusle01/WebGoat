// [가정 1] 이 코드는 UserServiceTest.java의 테스트 메서드 내부에 위치합니다.
// [가정 2] 테스트용 패스워드는 환경변수 또는 시스템 프로퍼티로 주입됩니다.
// [가정 3] 테스트 환경에서는 .env 파일 또는 CI/CD 시크릿 변수로 관리됩니다.

// 방법 1: 환경변수에서 읽기 (권장 - CI/CD 환경)
var password = System.getenv("TEST_USER_PASSWORD");
if (password == null || password.isBlank()) {
    throw new IllegalStateException(
        "필수 환경변수 'TEST_USER_PASSWORD'가 설정되지 않았습니다. " +
        "테스트 실행 전 환경변수를 설정하세요."
    );
}

// 방법 2: 시스템 프로퍼티에서 읽기 (환경변수 미설정 시 폴백)
// var password = System.getProperty("test.user.password");
// if (password == null || password.isBlank()) {
//     throw new IllegalStateException(
//         "시스템 프로퍼티 'test.user.password'가 설정되지 않았습니다. " +
//         "-Dtest.user.password=<value> 옵션으로 실행하세요."
//     );
// }