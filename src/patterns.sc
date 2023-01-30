patterns:
    $card = $regexp_i<^.*(карт[а-я])(чка)?.*$>
    $pension = $regexp_i<^.*(пенси).*$>
    $socialpayments = $regexp_i<^.*(соц)|(детских)|(пособий).*$>
    $whatisimportant = $regexp_i<^.*(мастеркард)|(виза)|(получ)|(налич)|(платеж)|(плат)?.*$>
    $cashback = $regexp_i<^.*(к[е|э]ш\s?б[е|э]к)|(cash-back)?.*$>
    $cashwithdrawal = $regexp_i<^.*(снимать)|(снял)|(лимит)?.*$>
    $250 = $regexp_i<^.*(250\s?000)?.*$>
    $500 = $regexp_i<^.*(500\s?000)?.*$>
    $millon = $regexp_i<^.*(1\s000\s?000)?.*$>
    $freeservice = $regexp_i<^.*(мир)|(обслужива)|(народн)|(пользов)|(без платеж)?.*$>