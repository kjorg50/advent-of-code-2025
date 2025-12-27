mkdir "$1"
cp dayXX.kt "$1"/day"$1".kt
sed -i '' "s/Day XX/Day $1/" "$1"/day"$1".kt
sed -i '' "s|day/x|day/$((10#$1))|" "$1"/day"$1".kt
