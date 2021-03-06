package com.jrestless.security;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class OpenIdStandardClaimsTest extends ClaimsTest<OpenIdStandardClaims> {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "getSub", "sub", "someSubValue" },
                 { "getName", "name", "someNameValue" },
                 { "getGivenName", "given_name", "someGivenNameValue" },
                 { "getFamilyName", "family_name", "someFamilyNameValue" },
                 { "getMiddleName", "middle_name", "someMiddleNameValue" },
                 { "getNickname", "nickname", "someNicknameValue" },
                 { "getPreferredUsername", "preferred_username", "somePreferredUsernameValue" },
                 { "getProfile", "profile", "someProfileValue" },
                 { "getPicture", "picture", "somePictureValue" },
                 { "getWebsite", "website", "someWebsiteValue" },
                 { "getEmail", "email", "someEmailValue" },
                 { "getEmailVerified", "email_verified", true },
                 { "getGender", "gender", "someGenderValue" },
                 { "getBirthdate", "birthdate", "someBirthdateValue" },
                 { "getZoneinfo", "zoneinfo", "someZoneinfoValue" },
                 { "getLocale", "locale", "someLocaleValue" },
                 { "getPhoneNumber", "phone_number", "somePhoneNumberValue" },
                 { "getPhoneNumberVerified", "phone_number_verified", true },
                 { "getUpdatedAt", "updated_at", 123L }
           });
    }

	public OpenIdStandardClaimsTest(String getterName, String key, Object value) throws NoSuchMethodException, SecurityException {
		super(getterName, key, value);
	}

	@Override
	OpenIdStandardClaims getClaims() {
		return new OpenIdStandardClaims() {
			@Override
			public OpenIdAddressClaims getAddress() {
				return null;
			}

			@Override
			public Map<String, Object> getAllClaims() {
				return getClaimsMap();
			}
		};
	}

	@Override
	Method getGetterByName(String getterName) throws NoSuchMethodException, SecurityException {
		return OpenIdStandardClaims.class.getMethod(getterName);
	}

}
