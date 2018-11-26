import { RegisterUserModule } from './register-user.module';

describe('RegisterUserModule', () => {
  let registerUserModule: RegisterUserModule;

  beforeEach(() => {
    registerUserModule = new RegisterUserModule();
  });

  it('should create an instance', () => {
    expect(registerUserModule).toBeTruthy();
  });
});
