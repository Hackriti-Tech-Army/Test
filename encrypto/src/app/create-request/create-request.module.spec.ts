import { CreateRequestModule } from './create-request.module';

describe('CreateRequestModule', () => {
  let createRequestModule: CreateRequestModule;

  beforeEach(() => {
    createRequestModule = new CreateRequestModule();
  });

  it('should create an instance', () => {
    expect(createRequestModule).toBeTruthy();
  });
});
