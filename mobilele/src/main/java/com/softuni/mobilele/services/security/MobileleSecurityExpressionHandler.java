package com.softuni.mobilele.services.security;

import com.softuni.mobilele.services.OfferService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class MobileleSecurityExpressionHandler extends
    AbstractSecurityExpressionHandler<MethodInvocation>  {

  private final OfferService offerService;

  public MobileleSecurityExpressionHandler(OfferService offerService) {
    this.offerService = offerService;
  }

  @Override
  protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
      MethodInvocation invocation) {
    OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication,
        offerService);

    root.setPermissionEvaluator(getPermissionEvaluator());
    root.setTrustResolver(new AuthenticationTrustResolverImpl());
    root.setRoleHierarchy(getRoleHierarchy());

    return root;
  }
}