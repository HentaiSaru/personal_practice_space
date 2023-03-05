const path = require('path');
module.exports = {
  entry: {
    
    // bootstrap:'./Css/animate.min.css',
    BT:'./Css/BT.css',
    // animate:'./Css/animate.min.css',

  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader'],
        include: [
            path.resolve(__dirname, 'Cssout'),
        ],
      },
    ],
  },
  output: {
    path: path.resolve(__dirname, 'jsout'),
    filename: 'Main.bundle.css',
  }
};