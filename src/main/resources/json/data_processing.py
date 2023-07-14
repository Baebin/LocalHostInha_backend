import json
import requests

with open('zero-waste-shop.json', 'r', encoding='utf-8') as f:
    data = json.load(f)
f.close()

ls = [{'name': x['properties']['CONTENTS_NAME'], 'coord_x': x['properties']['COORD_X'], 'coord_y': x['properties']['COORD_Y']} for x in data['features']]

with open('zero-waste-shop-processed.json', 'w', encoding='utf-8') as f:
    json.dump(ls, f, ensure_ascii=False, indent='\t')

# DB API
print(ls)
url = "http://localhost:8080/api/test/geomap/save"
for info in ls:
    datas = {
        'name': info['name'],
        'coord_x': float(info['coord_x']),
        'coord_y': float(info['coord_y'])
    }
    res = requests.get(url, params=datas)
    print(datas, res)
f.close()