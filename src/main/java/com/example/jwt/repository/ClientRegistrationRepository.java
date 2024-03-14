package com.example.jwt.repository;
@Bean
public class ClientRegistrationRepository() {
    return new InMemoryClientRegistrationRepository(this.keycloakClientRegistration());
}

private ClientRegistration keycloakClientRegistration(){
    return ClientRegistration.wtihRegistrationId("keycloak")
            .clientId("keycloak-client-id")
            .clientSecret("keycloak-client-secret")
            .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
            .authorizationGrantType(AuthorizationGrantType.AUHORIZATION_CODE)
            .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
            .scope("openid","profile","email","address","phone")
            .authorizationUri("http://localhost:8080/realms/oauth2")
            .tokenUri("http://localhost:8080/realms/oauth2/token")
            .userInfoUri("http://localhost:8080/realms/oauth2/userinfo")
            .userNameAttributeName(UdTokenClaimNames.SUB)
            .jwtSetUri("http://localhost:8080/realms/oatuh2/certs")
            .clientName("Keycloak")
            .build();
}
}
