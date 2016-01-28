import com.pixisolutions.pixiplatform.security.Role
import com.pixisolutions.pixiplatform.security.User
import com.pixisolutions.pixiplatform.security.UserRole
import com.pixisolutions.pixiplatform.security.oauth2.Client

class BootStrap {

    private static final String REDIRECT_URI = 'http://localhost/callback.php'

    def init = { servletContext ->
        if(User.count() == 0){
            Role roleUser = new Role(authority: 'ROLE_USER').save(flush: true)
            Role roleAdmin = new Role(authority: 'ROLE_ADMIN').save(flush: true)

            User user = new User(
                    username: 'user',
                    password: 'test',
                    enabled: true,
                    accountExpired: false,
                    accountLocked: false,
                    passwordExpired: false
            ).save(flush:true)

            UserRole.create(user, roleUser, true)

            User admin = new User(
                    username: 'admin',
                    password: 'admin',
                    enabled: true,
                    accountExpired: false,
                    accountLocked: false,
                    passwordExpired: false
            ).save(flush: true)

            UserRole.create(admin, roleAdmin, true)

            new User(
                    username: 'common-name',
                    password: 'the-user',
                    enabled: true,
                    accountExpired: false,
                    accountLocked: false,
                    passwordExpired: false
            ).save(flush: true)

            new Client(
                    clientId: 'common-name',
                    clientSecret: 'the-client',
                    authorizedGrantTypes: ['client_credentials'],
                    scopes: ['test']
            ).save(flush: true)

            new Client(
                    clientId: 'no-grant-client',
                    authorizedGrantTypes: [],
                    scopes: ['test']
            ).save(flush: true)

            new Client(
                    clientId: 'public-client',
                    authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                    authorities: ['ROLE_CLIENT'],
                    scopes: ['read', 'write', 'delete', 'test'],
                    redirectUris: [REDIRECT_URI]
            ).save(flush: true)

            new Client(
                    clientId: 'confidential-client',
                    clientSecret: 'secret-pass-phrase',
                    authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                    authorities: ['ROLE_TRUSTED_CLIENT'],
                    scopes: ['read', 'write', 'delete', 'trust', 'test'],
                    redirectUris: [REDIRECT_URI]
            ).save(flush: true)

            new Client(
                    clientId: 'password-only',
                    authorizedGrantTypes: ['password'],
                    scopes: ['test']
            ).save(flush: true)

            new Client(
                    clientId: 'password-and-scopes',
                    authorizedGrantTypes: ['password'],
                    scopes: ['read', 'write', 'delete', 'test']
            ).save(flush: true)

            new Client(
                    clientId: 'client-credentials-and-scopes',
                    authorizedGrantTypes: ['client_credentials'],
                    scopes: ['read', 'write', 'delete', 'test']
            ).save(flush: true)

            new Client(
                    clientId: 'no-redirect-uri',
                    authorizedGrantTypes: ['authorization_code', 'implicit'],
                    scopes: ['test']
            ).save(flush: true)

            new Client(
                    clientId: 'implicit-and-scopes',
                    authorizedGrantTypes: ['implicit'],
                    scopes: ['read', 'write', 'test'],
                    redirectUris: [REDIRECT_URI]
            ).save(flush: true)

            new Client(
                    clientId: 'authorization-code-only',
                    authorizedGrantTypes: ['authorization_code'],
                    redirectUris: [REDIRECT_URI],
                    scopes: ['test']
            ).save(flush: true)

            new Client(
                    clientId: 'implicit-only',
                    authorizedGrantTypes: ['implicit'],
                    scopes: ['test'],
                    redirectUris: [REDIRECT_URI]
            ).save(flush: true)

            new Client(
                    clientId: 'token-expiration',
                    authorizedGrantTypes: ['password', 'refresh_token'],
                    accessTokenValiditySeconds: 20,
                    refreshTokenValiditySeconds: 40,
                    scopes: ['test']
            ).save(flush: true)
        }
    }
    def destroy = {
    }
}
