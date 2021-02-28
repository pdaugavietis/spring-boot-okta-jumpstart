

okta:
  oauth2:
    issuer: https://dev-611140.okta.com/oauth2/aus4z02q32s6yHv5Z357
    client-id: 0oa7gi8ksxKxmadbF357
    client-secret: w4QOiPaxh04nYlUAlOchJmPPbrjC9gn0JZRz9zSf


vault kv put secret/okta-demo-app,dev \
okta.oauth2.client-id="0oa7gi8ksxKxmadbF357" \
okta.oauth2.client-secret="w4QOiPaxh04nYlUAlOchJmPPbrjC9gn0JZRz9zSf" \
okta.oauth2.issuer="https://dev-611140.okta.com/oauth2/aus4z02q32s6yHv5Z357"
vault kv get secret/okta-demo-app,dev

vault kv put secret-v2/okta-demo-app,dev \
okta.oauth2.client-id="0oa7gi8ksxKxmadbF357" \
okta.oauth2.client-secret="w4QOiPaxh04nYlUAlOchJmPPbrjC9gn0JZRz9zSf" \
okta.oauth2.issuer="https://dev-611140.okta.com/oauth2/aus4z02q32s6yHv5Z357"
vault kv get secret-v2/okta-demo-app,dev
