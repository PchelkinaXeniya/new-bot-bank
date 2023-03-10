patterns:
    $card = (карт*|ккарт*|карточк*)
    $pension = (пенси*)
    $socialPayments = (детск*|пособ*|соц*)
    $paymentCards = (mastercar*|мастеркар*|visa|виз*)
    $freePaymentCards = (mir|мир|народн*)
    $order = (заказ*|заявк*|замути*|откры*|заполн*)
    $design = (откр*|оформ*|интерес*)
    $wants = (хочу|хоте*|можн*)
    $salary = (зарплат*|заработ*|зп)
    $profit = (летел*|выгод*)
    $payments = (заплат*|опла*)
    #$cashback = (кеш бек|кэш бек|кэш бэк|кешбек|кэшбек|кэшбэк|cash-back|cash back|cash back)
    $cashback = $regexp_i<(к[е,э,а,ы]ш(\s*|-)б[е,э,а,ы]к|c[a,e]sh(\s*|-)b[a,e]ck)>
    $gets = (снят*|снима*|снял*)
    $limits = (лимит*|димит*|дофиг*|сколько (хоч*|нужн*|надо))
    $250 = $regexp<250\s*000>
    $500 = $regexp<500\s*000>
    $million = $regexp<1\s*000\s*000>
    $free = ({(без|беспл*) обслуж}*|бесплатн*|не плат*|без платеж*)
    $application = (прилож*|личн* кабин*|интернет банк|интернет-банк)
    $particles = (конечно|канешн*|однозначн*|определенн*|определённ*|разумее*)
    $yes = {([$particles] (да|даа|дааа|$particles))}
    $no = {[$particles] (не|нет|нету|неа)}