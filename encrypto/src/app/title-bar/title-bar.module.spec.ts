import { TitleBarModule } from './title-bar.module';

describe('TitleBarModule', () => {
  let titleBarModule: TitleBarModule;

  beforeEach(() => {
    titleBarModule = new TitleBarModule();
  });

  it('should create an instance', () => {
    expect(titleBarModule).toBeTruthy();
  });
});
