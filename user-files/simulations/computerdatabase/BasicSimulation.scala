/*
 * Copyright 2011-2021 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    // Here is the root for all relative URLs
    .baseUrl("https://sso.sekolahdesain.id")
    // Here are the common headers
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  // A scenario is a chain of requests and pauses
  val scn = scenario("Scenario Name")
    .exec(
      http("login")
        // Here's an example of a POST request
        .post("/auth/realms/master/protocol/openid-connect/token")
        .header("Content-Type", "application/x-www-form-urlencoded")
        // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
        .formParam("client_id", "kong")
        .formParam("client_secret", "e4b2601d-571c-4b33-af66-9eb6c52e64c5")
        .formParam("grant_type", "password")
        .formParam("username", "mahmud@gmail.com")
        .formParam("password", "12345678")
    )
    .exec(
      http("login")
        // Here's an example of a POST request
        .post("/auth/realms/master/protocol/openid-connect/token")
        .header("Content-Type", "application/x-www-form-urlencoded")
        // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
        .formParam("client_id", "kong")
        .formParam("client_secret", "e4b2601d-571c-4b33-af66-9eb6c52e64c5")
        .formParam("grant_type", "password")
        .formParam("username", "voucher7@gmail.com")
        .formParam("password", "12345678")
    )
    .exec(
      http("login")
        // Here's an example of a POST request
        .post("/auth/realms/master/protocol/openid-connect/token")
        .header("Content-Type", "application/x-www-form-urlencoded")
        // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
        .formParam("client_id", "kong")
        .formParam("client_secret", "e4b2601d-571c-4b33-af66-9eb6c52e64c5")
        .formParam("grant_type", "password")
        .formParam("username", "maulana.mclb666@gmail.com")
        .formParam("password", "12345678")
    )

  setUp(scn.inject(atOnceUsers(500)).protocols(httpProtocol))
}
