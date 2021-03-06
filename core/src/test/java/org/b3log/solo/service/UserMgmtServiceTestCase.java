/*
 * Copyright (c) 2009, 2010, 2011, 2012, B3log Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.solo.service;

import junit.framework.Assert;
import org.b3log.latke.Keys;
import org.b3log.latke.model.Role;
import org.b3log.latke.model.User;
import org.b3log.solo.AbstractTestCase;
import org.json.JSONObject;
import org.testng.annotations.Test;

/**
 * {@link UserMgmtService} test case.
 *
 * @author <a href="mailto:DL88250@gmail.com">Liang Ding</a>
 * @version 1.0.0.1, Feb 23, 2012
 */
@Test(suiteName = "service")
public class UserMgmtServiceTestCase extends AbstractTestCase {

    /**
     * Add User.
     * 
     * @throws Exception exception
     */
    @Test
    public void addUser() throws Exception {
        final UserMgmtService userMgmtService = getUserMgmtService();

        final JSONObject requestJSONObject = new JSONObject();

        requestJSONObject.put(User.USER_NAME, "user1 name");
        requestJSONObject.put(User.USER_EMAIL, "test1@gmail.com");
        requestJSONObject.put(User.USER_PASSWORD, "pass1");

        final String id = userMgmtService.addUser(requestJSONObject);
        Assert.assertNotNull(id);
    }

    /**
     * Update User.
     * 
     * @throws Exception exception
     */
    @Test(dependsOnMethods = "addUser")
    public void updateUser() throws Exception {
        final UserMgmtService userMgmtService = getUserMgmtService();

        JSONObject requestJSONObject = new JSONObject();

        requestJSONObject.put(User.USER_NAME, "user2 name");
        requestJSONObject.put(User.USER_EMAIL, "test2@gmail.com");
        requestJSONObject.put(User.USER_PASSWORD, "pass2");
        requestJSONObject.put(User.USER_ROLE, Role.ADMIN_ROLE);

        final String id = userMgmtService.addUser(requestJSONObject);
        Assert.assertNotNull(id);

        requestJSONObject.put(Keys.OBJECT_ID, id);
        requestJSONObject.put(User.USER_NAME, "user2 new name");

        userMgmtService.updateUser(requestJSONObject);
        
        Assert.assertEquals(getUserQueryService().getUser(id).getJSONObject(
                User.USER).getString(User.USER_NAME), "user2 new name");
    }

    /**
     * Remove User.
     * 
     * @throws Exception exception
     */
    @Test(dependsOnMethods = "addUser")
    public void removeUser() throws Exception {
        final UserMgmtService userMgmtService = getUserMgmtService();

        final JSONObject user =
                getUserQueryService().getUserByEmail("test1@gmail.com");
        Assert.assertNotNull(user);

        userMgmtService.removeUser(user.getString(Keys.OBJECT_ID));

        Assert.assertNull(
                getUserQueryService().getUserByEmail("test1@gmail.com"));
    }
}
