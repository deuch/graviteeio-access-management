/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.am.gateway.handler.oauth2.token;

import io.gravitee.am.gateway.handler.oauth2.request.OAuth2Request;
import io.gravitee.am.model.Client;
import io.gravitee.am.repository.oauth2.model.RefreshToken;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author Titouan COMPIEGNE (titouan.compiegne at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface TokenService {

    Maybe<AccessToken> getAccessToken(String accessToken);

    Maybe<RefreshToken> getRefreshToken(String refreshToken);

    Single<AccessToken> create(OAuth2Request oAuth2Request, Client client);

    Single<AccessToken> refresh(String refreshToken, OAuth2Request oAuth2Request, Client client);

    Completable deleteAccessToken(String accessToken);

    Completable deleteRefreshToken(String refreshToken);
}
