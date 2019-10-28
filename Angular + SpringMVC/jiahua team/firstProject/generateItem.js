// https://www.json-generator.com/#

[
  '{{repeat(2233, 3344)}}',
  {
    imgUrl: 'https://source.unsplash.com/random',
    category: '{{state()}}',
    subCategory: '{{city()}}',
    verified: [
      '{{integer(2000, 2050)}}',
      '{{integer(1, 12)}}',
      '{{integer(1, 28)}}'
    ],
    description: {
      Manufacturer: '{{company()}}',
      Series: "{{lorem(2, 'words')}}",
      Model: '{{objectId()}}'
    },
    type$: {
      Use_Type$type: '{{random("Commercial", "Industrial", "Residential")}}',
      Application$type: '{{random("Indoor", "Outdoor")}}',
      Mounting_Location$type: '{{random("Roof","Wall","Free standing")}}',
      Accessories$type: '{{random("With light","Without light")}}',
      Model_year$num: '{{integer(2000, 2050)}}'
    },
    technical_specifications$: {
      'Airflow (CFM)$num': '{{integer(0, 9999)}}',
      'Power (W).min$num': '{{floating(0, 3)}}',
      'Power (W).max$num': '{{floating(4, 7)}}',
      'Operating voltage (VAC).min$num': '{{integer(0, 99)}}',
      'Operating voltage (VAC).max$num': '{{integer(99, 999)}}',
      'Fan speed (RPM).min$num': '{{integer(0, 99)}}',
      'Fan speed (RPM).max$num': '{{integer(99, 999)}}',
      'Number of fan speeds$num': '{{integer(0, 10)}}',
      'Sound at max speed (dBA)$num': '{{integer(0, 99)}}',
      'Fan sweep diameter (in)$num': '{{integer(0, 99)}}',
      'Height (in).min$num': '{{floating(0, 25)}}',
      'Height (in).max$num': '{{floating(26, 70)}}',
      'Weights (lbs)$num': '{{integer(1, 25)}}'
    },
    series_information: ['{{repeat(7, 15)}}', '{{lorem()}}'],
    sales_representative: {
      Name: '{{firstName()}} {{surname()}}',
      Phone: '{{phone()}}',
      Email: '{{email()}}',
      Web: 'www.{{street()}}.com'
    },
    manufacturer: {
      Department: '{{country()}}',
      Phone: '{{phone()}}',
      Email: '{{email()}}',
      Web: 'www.{{lorem(1, "words")}}.com'
    },
    past_selections$: {
      firm$num: '{{integer(0, 13)}}',
      global$num: '{{integer(700, 1500)}}'
    }
  }
];
