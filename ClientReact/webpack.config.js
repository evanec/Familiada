module.exports = {
    devtool: 'source-map',
    output: {
        filename: 'react-app.js'
    },
    module: {
        rules: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            loader: "babel-loader",
            options: {
                presets: ['@babel/preset-env', '@babel/preset-react']
            }
        }, {
            test: /\.(css|min.css)$/,
            exclude: /node_modules/,
            use: ['style-loader', 'css-loader']
        },
               {
                 test: /\.(png|jpg|gif|svg|eot|ttf|woff|woff2)$/,
                 loader: 'url-loader',
                 options: {
                   limit: 10000
                 }
               }]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};
