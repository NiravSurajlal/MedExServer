import keyring
import simple_salesforce as sf
from medex.settings import __CREDENTIALS__

class ComplexSF(sf.Salesforce):
    def __init__(self, environment='production'):
        self.environment = environment
        __PASS_CREDENTIALS__ = __CREDENTIALS__['SalesforceSuDoAPIPassword']
        __KEY_CREDENTIALS__ = __CREDENTIALS__['SalesforceSuDoAPIToken']
        self.__username = __PASS_CREDENTIALS__['username']
        self.__pass_service_name = __PASS_CREDENTIALS__['service_name']
        self.__key_service_name = __KEY_CREDENTIALS__['service_name']
        self.__domain = None

        # need to add user credentials for staging in windows creds
        # uses test_primary@tecex.com.stagning for login creds instead
        if self.environment.lower() != 'production':
            self.__username += '.' + self.environment.lower()
            self.__pass_service_name += '.' + self.environment.lower()
            self.__key_service_name += '.' + self.environment.lower()
            self.__domain = 'test'
        
        # get user password
        password = keyring.get_password(self._ComplexSF__pass_service_name, self._ComplexSF__username)
        assert password is not None, "Could not find a Salesforce Login."

        # get user token
        api_token = keyring.get_password(self._ComplexSF__key_service_name, self._ComplexSF__username)
        assert api_token is not None, "Could not find a Salesforce Token."

        super().__init__(username=self.__username, 
                         password=password, 
                         security_token=api_token, 
                         domain=self.__domain)
# self._ComplexSF__key_service_name
# self._ComplexSF__username