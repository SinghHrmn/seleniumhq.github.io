package dev.selenium.virtual_authenticator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.virtualauthenticator.Credential;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.List;

public class VirtualAuthenticatorTest {

  /**
   * A pkcs#8 encoded encrypted RSA private key as a base64url string.
   */
  private final static String
    base64EncodedPK =
    "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDbBOu5Lhs4vpowbCnmCyLUpIE7JM9sm9QXzye2G+jr+Kr"
    + "MsinWohEce47BFPJlTaDzHSvOW2eeunBO89ZcvvVc8RLz4qyQ8rO98xS1jtgqi1NcBPETDrtzthODu/gd0sjB2Tk3TLuB"
    + "GVoPXt54a+Oo4JbBJ6h3s0+5eAfGplCbSNq6hN3Jh9YOTw5ZA6GCEy5l8zBaOgjXytd2v2OdSVoEDNiNQRkjJd2rmS2oi"
    + "9AyQFR3B7BrPSiDlCcITZFOWgLF5C31Wp/PSHwQhlnh7/6YhnE2y9tzsUvzx0wJXrBADW13+oMxrneDK3WGbxTNYgIi1P"
    + "vSqXlqGjHtCK+R2QkXAgMBAAECggEAVc6bu7VAnP6v0gDOeX4razv4FX/adCao9ZsHZ+WPX8PQxtmWYqykH5CY4TSfsui"
    + "zAgyPuQ0+j4Vjssr9VODLqFoanspT6YXsvaKanncUYbasNgUJnfnLnw3an2XpU2XdmXTNYckCPRX9nsAAURWT3/n9ljc/"
    + "XYY22ecYxM8sDWnHu2uKZ1B7M3X60bQYL5T/lVXkKdD6xgSNLeP4AkRx0H4egaop68hoW8FIwmDPVWYVAvo8etzWCtib"
    + "RXz5FcNld9MgD/Ai7ycKy4Q1KhX5GBFI79MVVaHkSQfxPHpr7/XcmpQOEAr+BMPon4s4vnKqAGdGB3j/E3d/+4F2swyko"
    + "QKBgQD8hCsp6FIQ5umJlk9/j/nGsMl85LgLaNVYpWlPRKPc54YNumtvj5vx1BG+zMbT7qIE3nmUPTCHP7qb5ERZG4CdMC"
    + "S6S64/qzZEqijLCqepwj6j4fV5SyPWEcpxf6ehNdmcfgzVB3Wolfwh1ydhx/96L1jHJcTKchdJJzlfTvq8wwKBgQDeCnK"
    + "ws1t5GapfE1rmC/h4olL2qZTth9oQmbrXYohVnoqNFslDa43ePZwL9Jmd9kYb0axOTNMmyrP0NTj41uCfgDS0cJnNTc63"
    + "ojKjegxHIyYDKRZNVUR/dxAYB/vPfBYZUS7M89pO6LLsHhzS3qpu3/hppo/Uc/AM /r8PSflNHQKBgDnWgBh6OQncChPUl"
    + "OLv9FMZPR1ZOfqLCYrjYEqiuzGm6iKM13zXFO4AGAxu1P/IAd5BovFcTpg79Z8tWqZaUUwvscnl+cRlj+mMXAmdqCeO8V"
    + "ASOmqM1ml667axeZDIR867ZG8K5V029Wg+4qtX5uFypNAAi6GfHkxIKrD04yOHAoGACdh4wXESi0oiDdkz3KOHPwIjn6B"
    + "hZC7z8mx+pnJODU3cYukxv3WTctlUhAsyjJiQ/0bK1yX87ulqFVgO0Knmh+wNajrb9wiONAJTMICG7tiWJOm7fW5cfTJw"
    + "WkBwYADmkfTRmHDvqzQSSvoC2S7aa9QulbC3C/qgGFNrcWgcT9kCgYAZTa1P9bFCDU7hJc2mHwJwAW7/FQKEJg8SL33KI"
    + "NpLwcR8fqaYOdAHWWz636osVEqosRrHzJOGpf9x2RSWzQJ+dq8+6fACgfFZOVpN644+sAHfNPAI/gnNKU5OfUv+eav8fB"
    + "nzlf1A3y3GIkyMyzFN3DE7e0n/lyqxE4HBYGpI8g==";

  private final static PKCS8EncodedKeySpec privateKey =
    new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(base64EncodedPK));

  private VirtualAuthenticator authenticator;
  public WebDriver driver;

  @BeforeEach
  public void setup() {
    driver = new ChromeDriver();
  }

  @AfterEach
  public void quit() {
    driver.quit();
  }

  @Test
  public void testCreateAuthenticator() {
    // Create virtual authenticator options
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.U2F)
      .setHasResidentKey(false);

    // Register a virtual authenticator
    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    List<Credential> credentialList = authenticator.getCredentials();

    Assertions.assertEquals(0, credentialList.size());
  }

  @Test
  public void testRemoveAuthenticator() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions();
    authenticator =
      ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    ((HasVirtualAuthenticator) driver).removeVirtualAuthenticator(authenticator);

    // Since the authenticator was removed, any operation using it will throw an error
    Assertions.assertThrows(InvalidArgumentException.class, authenticator::getCredentials);
  }

  @Test
  public void testCreateAndAddResidentialKey() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
      .setHasResidentKey(true)
      .setHasUserVerification(true)
      .setIsUserVerified(true);
    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    byte[] credentialId = {1, 2, 3, 4};
    byte[] userHandle = {1};
    Credential residentCredential = Credential.createResidentCredential(
      credentialId, "localhost", privateKey, userHandle, /*signCount=*/0);

    authenticator.addCredential(residentCredential);

    List<Credential> credentialList = authenticator.getCredentials();
    Assertions.assertEquals(1, credentialList.size());

    Credential credential = credentialList.get(0);
    Assertions.assertArrayEquals(credentialId, credential.getId());
  }

  @Test
  public void testAddResidentCredentialNotSupportedWhenAuthenticatorUsesU2FProtocol() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.U2F)
      .setHasResidentKey(true);

    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    // A pkcs#8 encoded unencrypted EC256 private key as a base64url string.
    String base64EncodedPK =
      "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg8_zMDQDYAxlU-Q"
      + "hk1Dwkf0v18GZca1DMF3SaJ9HPdmShRANCAASNYX5lyVCOZLzFZzrIKmeZ2jwU"
      + "RmgsJYxGP__fWN_S-j5sN4tT15XEpN_7QZnt14YvI6uvAgO0uJEboFaZlOEB";

    PKCS8EncodedKeySpec privateKey =
      new PKCS8EncodedKeySpec(Base64.getUrlDecoder().decode(base64EncodedPK));

    byte[] credentialId = {1, 2, 3, 4};
    byte[] userHandle = {1};
    Credential credential = Credential.createResidentCredential(
      credentialId, "localhost", privateKey, userHandle, /*signCount=*/0);

    Assertions.assertThrows(InvalidArgumentException.class,
                            () -> authenticator.addCredential(credential));
  }


  @Test
  public void testCreateAndAddNonResidentialKey() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.U2F)
      .setHasResidentKey(false);

    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    // A pkcs#8 encoded unencrypted EC256 private key as a base64url string.
    String base64EncodedPK =
      "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg8_zMDQDYAxlU-Q"
      + "hk1Dwkf0v18GZca1DMF3SaJ9HPdmShRANCAASNYX5lyVCOZLzFZzrIKmeZ2jwU"
      + "RmgsJYxGP__fWN_S-j5sN4tT15XEpN_7QZnt14YvI6uvAgO0uJEboFaZlOEB";

    PKCS8EncodedKeySpec privateKey =
      new PKCS8EncodedKeySpec(Base64.getUrlDecoder().decode(base64EncodedPK));

    byte[] credentialId = {1, 2, 3, 4};
    Credential nonResidentCredential = Credential.createNonResidentCredential(
      credentialId, "localhost", privateKey, /*signCount=*/0);
    authenticator.addCredential(nonResidentCredential);

    List<Credential> credentialList = authenticator.getCredentials();
    Assertions.assertEquals(1, credentialList.size());

    Credential credential = credentialList.get(0);
    Assertions.assertArrayEquals(credentialId, credential.getId());
  }

  @Test
  public void testGetCredential() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
      .setHasResidentKey(true)
      .setHasUserVerification(true)
      .setIsUserVerified(true);
    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    byte[] credentialId = {1, 2, 3, 4};
    byte[] userHandle = {1};
    Credential residentCredential = Credential.createResidentCredential(
      credentialId, "localhost", privateKey, userHandle, /*signCount=*/0);

    authenticator.addCredential(residentCredential);

    List<Credential> credentialList = authenticator.getCredentials();
    Assertions.assertEquals(1, credentialList.size());

    Credential credential = credentialList.get(0);
    Assertions.assertArrayEquals(credentialId, credential.getId());
    Assertions.assertTrue(credential.isResidentCredential());
    Assertions.assertArrayEquals(privateKey.getEncoded(), credential.getPrivateKey().getEncoded());

  }

  @Test
  public void testRemoveCredential() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
      .setHasResidentKey(true)
      .setHasUserVerification(true)
      .setIsUserVerified(true);
    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    byte[] credentialId1 = {1, 2, 3, 4};
    byte[] userHandle1 = {1};
    Credential residentCredential1 = Credential.createResidentCredential(
      credentialId1, "localhost", privateKey, userHandle1, /*signCount=*/0);

    String base64EncodedPK =
      "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg8_zMDQDYAxlU-Q"
      + "hk1Dwkf0v18GZca1DMF3SaJ9HPdmShRANCAASNYX5lyVCOZLzFZzrIKmeZ2jwU"
      + "RmgsJYxGP__fWN_S-j5sN4tT15XEpN_7QZnt14YvI6uvAgO0uJEboFaZlOEB";

    PKCS8EncodedKeySpec privateKey2 =
      new PKCS8EncodedKeySpec(Base64.getUrlDecoder().decode(base64EncodedPK));

    byte[] credentialId2 = {6, 7, 8, 9};
    Credential residentCredential2 = Credential.createNonResidentCredential(
      credentialId2, "localhost", privateKey2, 0);

    authenticator.addCredential(residentCredential1);
    authenticator.addCredential(residentCredential2);

    List<Credential> credentialList = authenticator.getCredentials();
    Assertions.assertEquals(2, credentialList.size());

    authenticator.removeCredential(credentialId2);
    Assertions.assertEquals(1, authenticator.getCredentials().size());
    Assertions.assertArrayEquals(credentialId1, authenticator.getCredentials().get(0).getId());

  }

  @Test
  public void testRemoveAllCredentials() {
    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
      .setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
      .setHasResidentKey(true)
      .setHasUserVerification(true)
      .setIsUserVerified(true);
    authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

    byte[] credentialId1 = {1, 2, 3, 4};
    byte[] userHandle1 = {1};
    Credential residentCredential1 = Credential.createResidentCredential(
      credentialId1, "localhost", privateKey, userHandle1, /*signCount=*/0);

    String base64EncodedPK =
      "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg8_zMDQDYAxlU-Q"
      + "hk1Dwkf0v18GZca1DMF3SaJ9HPdmShRANCAASNYX5lyVCOZLzFZzrIKmeZ2jwU"
      + "RmgsJYxGP__fWN_S-j5sN4tT15XEpN_7QZnt14YvI6uvAgO0uJEboFaZlOEB";

    PKCS8EncodedKeySpec privateKey2 =
      new PKCS8EncodedKeySpec(Base64.getUrlDecoder().decode(base64EncodedPK));

    byte[] credentialId2 = {6, 7, 8, 9};
    Credential residentCredential2 = Credential.createNonResidentCredential(
      credentialId2, "localhost", privateKey2, 0);

    authenticator.addCredential(residentCredential1);
    authenticator.addCredential(residentCredential2);

    List<Credential> credentialList = authenticator.getCredentials();
    Assertions.assertEquals(2, credentialList.size());

    authenticator.removeAllCredentials();
    Assertions.assertEquals(0, authenticator.getCredentials().size());
  }
}
