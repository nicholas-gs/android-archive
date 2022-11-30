# Android - PinLockScreen

_A simple and minimalistic pin lock screen that incorporates material design elements._

Google's [material design standards](https://material.io/design/motion/#usage) recommands adding motion and animation to a user interface to provide timely feedback and status of user actions.

With a PIN lock screen, animations can be used to confirm successful numpad inputs, as well as successful or unsuccessful password entries.

<br>

<img src="https://img.shields.io/badge/minSdkVersion-21-red.svg?style=true" alt="minSdkVersion 21" data-canonical-src="https://img.shields.io/badge/minSdkVersion-24-red.svg?style=true" style="max-width:100%;"> <img src=https://img.shields.io/badge/compileSdkVersion-28-brightgreen.svg alt="compileSdkVersion 28" data-canonical-src="https://img.shields.io/badge/compileSdkVersion-27-yellow.svg?style=true" style="max-width:100%;">

## PinLockScreen in action

Wrong PIN                    | Correct PIN
:-------------------------:|:-------------------------:
![wrong-pin-gif](https://user-images.githubusercontent.com/39665412/50641296-74c99f80-0fa2-11e9-9bb6-a992f09d1978.gif) | ![correct-pin-gif](https://user-images.githubusercontent.com/39665412/50641321-8612ac00-0fa2-11e9-9208-ddbdc50e798d.gif)

## Features to implement

1. Allow user to create choose their PIN number at first installation

2. Store the user's PIN number securely

Currently, the correct PIN is `1234` and is stored in the `strings.xml` file. While the android app does compare the user's input with this string, it is a bad idea to hardcode the actual PIN number like this.

## Libraries/Dependencies

1. [CircleImageView](https://github.com/hdodenhof/CircleImageView) by hdodenhof - A circular ImageView for Android, used for the circular profile picture

## Credits

Profile picture icon made by [Freepik](https://www.freepik.com/) from www.flaticon.com

## License

```tex
MIT License

Copyright (c) 2018 Nicholas Gan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```