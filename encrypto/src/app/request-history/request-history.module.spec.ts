import { RequestHistoryModule } from './request-history.module';

describe('RequestHistoryModule', () => {
  let requestHistoryModule: RequestHistoryModule;

  beforeEach(() => {
    requestHistoryModule = new RequestHistoryModule();
  });

  it('should create an instance', () => {
    expect(requestHistoryModule).toBeTruthy();
  });
});
